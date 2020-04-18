/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 *
 * https://leetcode-cn.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (31.31%)
 * Total Accepted:    1.6K
 * Total Submissions: 5.1K
 * Testcase Example:  '"3+2*2"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * 
 * 示例 1:
 * 
 * 输入: "3+2*2"
 * 输出: 7
 * 
 * 
 * 示例 2:
 * 
 * 输入: " 3/2 "
 * 输出: 1
 * 
 * 示例 3:
 * 
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 
 * 
 * 说明：
 * 
 * 
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        char simple = '+';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                temp = temp * 10 + c - '0';
            }
            if ((c != ' ' && !(c >= '0' && c <= '9')) || count == s.length() - 1) { // 最后一个数需要算
                if (simple == '+') {
                    stack.push(temp);
                } else if (simple == '-') {
                    stack.push(-temp);
                } else if (simple == '*') {
                    stack.push(stack.pop() * temp);
                } else {
                    stack.push(stack.pop() / temp);
                }
                temp = 0;
                simple = c;
            }
            count++;
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
