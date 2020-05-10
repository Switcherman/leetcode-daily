/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char c = str.charAt(0);
        if (!Character.isDigit(c) && '-' != c && '+' != c) {
            return 0;
        }
        boolean neg = '-' == c;
        long res = 0L;
        int index = Character.isDigit(c) ? 0 : 1;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            res = res * 10 + (str.charAt(index) - '0');
            if (!neg && res > Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
                break;
            }
            if (neg && res > 1L + Integer.MAX_VALUE) {
                res = 1L + Integer.MAX_VALUE;
                break;
            }
            index++;
        }
        return neg ? (int) -res : (int) res;
    }
}
// @lc code=end

