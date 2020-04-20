/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int r = 0;
        while (i < j) {
            int s = (j - i) * Math.min(height[i], height[j]);
            r = Math.max(s, r);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return r;
    }
}
// @lc code=end

