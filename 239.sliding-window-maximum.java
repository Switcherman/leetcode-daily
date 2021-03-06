/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (40.21%)
 * Total Accepted:    2.9K
 * Total Submissions: 7.2K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k
 * 内的数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口最大值。
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7] 
 * 解释: 
 * 
 * ⁠ 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 注意：
 * 
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * 
 * 进阶：
 * 
 * 你能在线性时间复杂度内解决此题吗？
 * 
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        leftMax[0] = nums[0];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = (i % k) == 0 ? nums[i] : Math.max(nums[i], nums[i - 1]);
            int j = nums.length - i - 1;
            rightMax[j] = (j % k) == 0 ? nums[j] : Math.max(nums[j], nums[j + 1]);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }
        return result;
    }


   
}
