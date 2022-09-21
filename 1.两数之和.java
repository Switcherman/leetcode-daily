/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.get(gap) != null) {
                result[0] = i;
                result[1] = map.get(gap);
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }
    
}
// @lc code=end

