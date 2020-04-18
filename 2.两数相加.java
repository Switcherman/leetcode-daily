/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode result = new ListNode(0);
        ListNode move = result;
        while (l1 != null && l2 != null) {
            int node = l1.val + l2.val + add;
            add = node / 10;
            node = node % 10;
            move.next = new ListNode(node);
            move = move.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int node = l1.val + add;
            add = node / 10;
            node = node % 10;
            move.next = new ListNode(node);
            move = move.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int node = l2.val + add;
            add = node / 10;
            node = node % 10;
            move.next = new ListNode(node);
            move = move.next;
            l2 = l2.next;
        }
        if (add != 0) {
            move.next = new ListNode(add);
        }
        return result.next;
    }
}
// @lc code=end

