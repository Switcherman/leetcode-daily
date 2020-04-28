/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (fast != slow);
        return slow == 1;
    }

    public int bitSquareSum(int n) {
        int sum = 0;
        int bit = 0;
        while (n != 0) {
            bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }

}
// @lc code=end

