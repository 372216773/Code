package greedy;
/*
前缀树
 */
public class TrieTree {
    public static class TrieNode {
        //被通过()了多少次
        public int pass;
        //是多少个字符串的结尾节点
        public int end;
        //26个位置上有哪些作为下一个节点
        /*
        如果字符种类比较多,就用hashMap,hashSet
         */
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            /*
            从这个结点出发会有26种路
            nests[0]==null;表示没有走向'a'的路
            nexts[0]!=null;表示有走向'a'的路
            ...
            nexts[25]==null;表示没有走向'z'的路
            nexts[25]!=null;表示有走向'z'的路
             */
            this.nexts = new TrieNode[26];
        }
    }

    //相关操作
    public static class Trie {
        private TrieNode root = null;

        public Trie() {
            this.root = new TrieNode();
        }

        //插入到前缀树
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            //经过一次
            node.pass++;
            int index = 0;
            for (char aChar : chars) {
                //在26个位置上,中的哪个位置上
                index = aChar - 'a';
                //如果在这个位置上没有这个节点a,b,c,d,就创建这个节点
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                //node指向下一个节点,遍历
                node = node.nexts[index];
                node.pass++;
            }
            //最后一个节点end++,字符串的最后一个字符的end++;
            node.end++;
        }

        //删除单词(重复的只删一次)
        public void delete(String word) {
            if (word == null || search(word) == 0) return;
            TrieNode node = new TrieNode();
            node.pass--;
            int index = 0;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                //规定检查路线
                index = aChar - 'a';
                //就是这次删除经过这个节点的pass时,发现为0,即就是没有经过这个点的字符串了,就直接返回
                if (--node.nexts[index].pass == 0) {
                    //直接标空
                    node.nexts[index] =null;
                    return;
                }
                    //遍历
                    node = node.nexts[index];
            }
            node.end--;
        }

        //搜索有几个这个的单词
        public int search(String word) {
            if (word == null) return 0;
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = new TrieNode();
            for (char aChar : chars) {
                //根据index来判断该检查哪条路
                index = aChar - 'a';
                //没路了,但是字符没结束,就说明没有这个单词
                if (node.nexts[index] == null) return 0;
                //节点走到下一个节点上
                node = node.nexts[index];
            }
            //循环结束还没有return,说明有这个单词
            return node.end;
        }

        //所有加入的字符串中,有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) return 0;
            TrieNode node = new TrieNode();
            int index = 0;
            char[] chars = pre.toCharArray();
            for (char aChar : chars) {
                //寻找的路径
                index = aChar - 'a';
                //没路了,但是字符没结束,就没有这个前缀的
                if (node.nexts[index] == null) return 0;
                node = node.nexts[index];
            }
            //循环结束还没有退出
            return node.pass;
        }
    }
}
