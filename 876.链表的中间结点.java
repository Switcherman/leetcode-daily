/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode fast = head.next.next;
        while (head != null && fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head.next;
    }
}
// @lc code=end

