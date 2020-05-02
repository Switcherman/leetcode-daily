/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 找到最小字符转
        String least = strs[0];
        for (String str : strs) {
            if (str.length() < least.length()) {
                least = str;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < least.length(); i++) {
            for(String str : strs) {
                if (str.charAt(i) != least.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(least.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end

