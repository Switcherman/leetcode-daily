/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 区间按起始位置排序
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        int index = -1;
        int[][] res = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (index == -1 || res[index][1] < interval[0]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(interval[1], res[index][1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}
// @lc code=end

