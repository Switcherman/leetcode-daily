/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
    
        if(s.length() < 2) {
            return s.length();
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index != null) {
                left = Math.max(index + 1, left);
            }
            result = Math.max(result, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return result;
    }
}
// @lc code=end

