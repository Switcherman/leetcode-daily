/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - temp) < Math.abs(target - result)) {
                    result = temp;
                }
                if (temp > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
// @lc code=end

