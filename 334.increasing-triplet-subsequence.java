/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 *
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/description/
 *
 * algorithms
 * Medium (32.22%)
 * Total Accepted:    3.4K
 * Total Submissions: 10.5K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 
 * 数学表达式如下:
 * 
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: [5,4,3,2,1]
 * 输出: false
 * 
 */
class Solution {
    // 贪心算法, 记录最小值和中值.
    public boolean increasingTriplet(int[] nums) {
        int little = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= little) {
                little = nums[i];
            } else if (nums[i] > little && nums[i] <= middle) {
                middle = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
