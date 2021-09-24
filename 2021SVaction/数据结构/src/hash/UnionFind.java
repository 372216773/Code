package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
并查集结构
1. isSameSet():	判断两个集合是否相同
2. union():     连接两个集合
当两个方法调用findHead的次数很频繁逼近或超过O(N),平均单次findHead时间复杂度O(1)
要求初始化,开始所有元素都为单个集合
 */
public class UnionFind {

    /**
     * 元素类,用来包裹样本
     *
     * @param <V>
     */
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    /**
     * 并查集结构
     *
     * @param <V>
     */
    public static class UnionFindSet<V> {
        //key:样本-->value:元素
        public HashMap<V, Element<V>> elementMap;
        //key:元素-->value:代表元素
        public HashMap<Element<V>, Element<V>> fatherMap;
        //key:某个集合的代表元素-->value:集合大小
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                //每个元素就是一个集合,集合大小为1
                sizeMap.put(element, 1);
            }
        }

        /**
         * 查找指定元素的代表(头)结点
         *
         * @param element 想要查找代表元素的节点
         * @return 返回代表元素
         */
        public Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            //元素的父节点不为当前元素
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            /*
            找一个元素与另外一个元素是否是同一集合的过程,如果元素在集合的底部,链过长,一直向上找,找到最顶点,很耗时间,所以进行优化
            优化: 扁平化
            整条路径中所有元素的father直接设置为最顶的元素
            如果只有一层,这个操作就不会有影响
            */
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        /**
         * 判断两个元素是否在同一集合中
         *
         * @param a 元素a
         * @param b 元素b
         * @return true/false
         */
        public boolean isSameSet(V a, V b) {
            //查找是否属于同一集合中,首先要满足的条件是两个元素都在map中出现过
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        /**
         * 合并两个元素
         *
         * @param a 元素a
         * @param b 元素b
         */
        public void union(V a, V b) {
            //首先要满足的条件是两个元素都在map中出现过
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                //a元素的代表元素
                Element<V> aHead = findHead(elementMap.get(a));
                //b元素的代表元素
                Element<V> bHead = findHead(elementMap.get(b));
                //头元素不相等,才进行合并
                if (aHead != bHead) {
                    Element<V> big = sizeMap.get(aHead) > sizeMap.get(bHead) ? aHead : bHead;
                    Element<V> small = big == aHead ? bHead : aHead;
                    //更新fatherMap
                    fatherMap.put(small, big);
                    //更新sizeMap
                    sizeMap.put(big, sizeMap.get(small) + sizeMap.get(big));
                    //small节点不再作为代表结点,所以删除
                    sizeMap.remove(small);
                }
            }
        }
    }
}
