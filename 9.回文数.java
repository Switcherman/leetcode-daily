/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        LinkedList<Integer> list = new LinkedList();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        while (list.size() > 1) {
            if (list.get(0) == list.get(list.size() - 1)) {
                list.remove(0);
                list.remove(list.size() - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

