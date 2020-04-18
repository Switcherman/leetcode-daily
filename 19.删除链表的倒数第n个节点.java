/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode aHead = new ListNode(0);
        aHead.next = head;
        while (n > 0) {
            head = head.next;
            n--;
        }
        ListNode before = aHead;
        while (head != null) {
            head = head.next;
            before = before.next;
        }
        ListNode temp = before.next;
        before.next = temp.next;
        temp.next = null;
        return aHead.next;
    }
}
// @lc code=end

