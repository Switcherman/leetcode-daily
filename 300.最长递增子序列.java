/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp数组
        int[] dp = new int[nums.length];
        // 初始化值
        Arrays.fill(dp, 1);
        // 状态转移方程 
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 1;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
        
    }
}
// @lc code=end

