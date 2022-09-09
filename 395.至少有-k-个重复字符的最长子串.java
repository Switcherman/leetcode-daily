/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        // s 长度小于k 结束递归
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) < k) {
                String[] subStrings = s.split(String.valueOf(c));
                int res = 0;
                for (String subString : subStrings) {
                    res = Math.max(res, longestSubstring(subString, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
// @lc code=end

