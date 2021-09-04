package nowCoder;

import java.util.Scanner;
/*
题目描述
在庆祝祖国母亲70华诞之际，老师给小乐乐出了一个问题。大家都知道China的英文缩写是CHN，那么给你一个字符串s，你需要做的是统计s中子串“CHN”的个数。
子串的定义：存在任意下标a < b < c，那么“s[a]s[b]s[c]”就构成s的一个子串。如“ABC”的子串有“A”、“B”、“C”、“AB”、“AC”、“BC”、“ABC”。

输入描述:
输入只包含大写字母的字符串s。(1 ≤ length ≤ 8000)
输出描述:
输出一个整数，为字符串s中字串“CHN”的数量。
示例1
输入
CCHNCHN
输出
7
示例2
输入
CCHNCHNCHNCHN
输出
30
 */
public class solution1 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.next();
    char[] chars = str.toCharArray();
    long countC = 0;
    long countCH = 0;
    long countCHN = 0;
    for (char ch:chars) {
        if (ch == 'C') {
            countC ++;
        } else if (ch == 'H') {
            countCH += countC;
        } else if (ch == 'N') {
            countCHN += countCH;
        }
    }
    System.out.println(countCHN);
}
}
/*
从前到后遍历字符串,出现'C'就countC++
如果后面出现一个'H',那就和之前的'C'组合成'CH'的个数countCH += countC
如果后面出现一个'N',那就和之前的'CH'组合成'CHN'的个数countCHN += countCH;
 */