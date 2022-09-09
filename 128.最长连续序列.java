/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {     
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestLength = 0;
        for (Integer num : set) {
            // 存在前驱数,跳过
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }
                longestLength = Math.max(currentLength, longestLength);
            }
        }
        return longestLength;
    }
}
// @lc code=end

