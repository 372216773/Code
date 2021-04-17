package OJ.stack;

import java.util.Deque;
import java.util.LinkedList;
//括号匹配问题-->顺序,倒序问题
/*
    有效的括号
    给定一个只包括'(', ')', '{', '}', '[', ']的字符串,判断字符串是否有效
    有效字符串满足:
        1.左括号必须用相同类型的右括号闭合
        2.左括号必须以正确的顺序闭合
    注意空字符串可被认为是有效字符串

    "{)"
    "{()"
    "()}"
 */
/*
伪代码:
    1.准备好一个放字符(char/Character)的栈
    2.遍历String字符串的每一个字符
        根据字符的不同,进行不同的处理:
        1.如果是左括号: {([  统一压入栈中
        2.如果是右括号:需要从栈顶带一个元素走
        出现三种情况:
            1.发现站是空的-->右括号多了
            2.栈不为空,但是栈顶的左括号和现在的有括号不匹配-->匹配错误
            3.刚好匹配
    3.再去检查,栈是不是一个空的栈
        1.栈是空的-->正确
        2.栈不为空-->错误
 */
public class Solution {

    public boolean isValid(String s) {
        //1.准别好一个放Character类型的栈
        Deque<Character> stack = new LinkedList<>();

        //2.遍历s的每一个字符
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    //因为没有break,所以无论'(','{','['都会执行
                    stack.push(c);
                    break;
                //上边都没有匹配到,才进来,一定是右括号
                default: {
                    if (stack.isEmpty()) {
                        //右括号多了
                        return false;
                    }
                    //否则取出栈顶元素
                    char left = stack.pop();
                    //进行左右括号的比较
                    if (!compareBracket(left, c)) {
                        //左括号和右括号不匹配
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean compareBracket(char left, char right) {
        return left == '(' && right == ')' || left == '{' && right == '}' || left == '[' && right == ']';
    }

}
