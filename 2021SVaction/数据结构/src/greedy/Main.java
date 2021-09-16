package greedy;

import java.util.Scanner;

//字符串中出现次数最多的单词和出现次数
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String article = scanner.next();
        String string = article.replaceAll(",", " ").replaceAll("\\.", " ").replaceAll("!", " ");
        String[] words = string.split(" ");
        TreNode node = new TreNode();
        TotalNum totalNum = new TotalNum();
        for (String word : words) {
            insert(node, word, totalNum);
        }
        System.out.println(totalNum);
    }

    public static void insert(TreNode node, String word, TotalNum totalNum) {
        if (word == null) return;
        char[] chars = word.toCharArray();
        node.past = 1;

        int index = 0;
        for (char aChar : chars) {
            index = aChar - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TreNode();
            }
            //遍历
            node = node.nexts[index];
            node.past++;
        }
        node.end++;
        totalNum.method(node.end, word);
    }


}

class TreNode {
    public int past;
    public int end;
    public TreNode[] nexts;

    public TreNode() {
        this.past = 0;
        this.end = 0;
        this.nexts = new TreNode[26];
    }
}

class TotalNum {
    int max;
    String word;

    public void method(int num, String word) {
        if (num > max) {
            this.max = num;
            this.word = word;
        }
    }

    @Override
    public String toString() {
        return "greedyAlgorithm.TotalNum{" +
                "max=" + max +
                ", word='" + word + '\'' +
                '}';
    }
}
