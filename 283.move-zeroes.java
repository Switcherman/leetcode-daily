/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (52.07%)
 * Total Accepted:    31.7K
 * Total Submissions: 60.9K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        // 记录0的个数,就是前移的位数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 遇0 count值+1
            if (nums[i] == 0) {
                count++;
            } else { // 非0数字前移count位
                nums[i - count] = nums[i];
            }
        }
        while (count > 0) { //最后count位变0
            nums[nums.length - count] = 0;
            count--;
        }
    }
}
