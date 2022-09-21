/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String result = s.substring(0, 1);
        int maxLength = 1;
        for (int i = 1; i < length; i++) { // 右边界
            for (int j = 0; j < i; j++) { // 左边界
                if (chars[i] == chars[j] && ((i - j <= 2) || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        result = s.substring(j, i + 1);
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

