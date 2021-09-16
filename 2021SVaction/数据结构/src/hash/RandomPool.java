package hash;

import java.util.HashMap;

/*
设计RandomPool结构
【题目】
设计一种结构，在该结构中有如下三个功能:
insert(key):将某个key加入到该结构，做到不重复加入
delete(key):将原本在结构中的某个key移除
getRandom(): 等概率随机返回结构中的任何一个key。(数据连续的话,随机会方便很多)
【要求】
Insert、delete和getRandom方法的时间复杂度都是O(1)
 */
public class RandomPool {
    public static class pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public pool() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key) {
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size, key);
                this.size++;
            }
        }

        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = indexKeyMap.get(lastIndex);
                //最后一个元素的index修改为deleteIndex,此时map中就有两个deleteIndex的key
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
                this.size--;
            }
        }

        public K getRandom() {
            if (this.size == 0) return null;
            int randomIndex = (int) (Math.random() * this.size);//0~size-1
            return this.indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        pool<String> pool = new pool<>();
        pool.insert("a");
        pool.insert("b");
        pool.insert("c");
        pool.insert("d");
        pool.delete("a");
        System.out.println(pool.getRandom());
    }

}
