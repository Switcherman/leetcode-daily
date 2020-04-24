/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int result = 0;
        int i = 0;
        while (i < height.length) {
            int j = i + 1;
            while (j < height.length && height[i] > height[j]) {
                j++;
            }
            int temp = calShower(height, i, j);
            result += temp;
            i = j;
        }
        return result;
    }

    private int calShower(int[] nums, int i, int j) {
        int s = nums[i] * (j - i - 1);
        int sum = 0;
        i = i + 1;
        while (i < j) {
            sum += nums[i++];
        }
        return s - sum;
    }
}
// @lc code=end

