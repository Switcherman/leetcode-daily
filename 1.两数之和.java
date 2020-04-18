/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            Integer index = map.get(gap);
            if (index != null) {
                result[0] = i;
                result[1] = index;
                return result;
            }
            map.put(nums[i], i);
        }

        return null;
    }
    
}
// @lc code=end

