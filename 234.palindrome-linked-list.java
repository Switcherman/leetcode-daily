/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (34.78%)
 * Total Accepted:    14.7K
 * Total Submissions: 42.2K
 * Testcase Example:  '[1,2]'
 *
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2
 * 输出: false
 * 
 * 示例 2:
 * 
 * 输入: 1->2->2->1
 * 输出: true
 * 
 * 
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针找到中间节点.
        // 中间断开后前半链表翻转
        // 判断是否相等
        ListNode pre = null;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            pre = slow;
            quick = quick.next.next;
            slow = slow.next;
        }
        pre.next = null;
        if (quick != null) {//奇数个链表
            slow = slow.next;
        }
        ListNode r = reverse(slow);
        while (r != null && head != null) {
            if (r.val != head.val) {
                return false;
            }
            r = r.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
