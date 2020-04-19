/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index != null) {
                left = Math.max(left, index + 1);
            }
            map.put(s.charAt(i), i);
            r = Math.max(r, i - left + 1);
        }
        return r;
    }
}
// @lc code=end

