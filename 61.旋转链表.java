/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) { return null;}
        if (head.next == null) { return head;}
        int n;
        ListNode oldTail = head;
        // 首尾相连,确定长度
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        // 确定新的尾结点
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        // 断开链表
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
// @lc code=end

