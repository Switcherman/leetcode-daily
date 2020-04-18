/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (57.29%)
 * Total Accepted:    6.5K
 * Total Submissions: 11.4K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 链表的归并排序
 * 1.归并排序.
 * 2.快慢指针找到中间节点
 * 3.链表的排序归并
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            pre = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(0);
        ListNode mark = head;
        while (l != null && r != null) {
            if (l.val > r.val) {
                head.next = r;
                r = r.next;
            } else {
                head.next = l;
                l = l.next;
            }
            head = head.next;
        }
        if (l != null) {
            head.next = l;
        }
        if (r != null) {
            head.next = r;
        }
        return mark.next;
    }

}
