/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (23.95%)
 * Total Accepted:    3.5K
 * Total Submissions: 14.7K
 * Testcase Example:  '{}'
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 
 * 要求返回这个链表的深度拷贝。 
 * 
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        //1.对原链表进行复制,复制到后一个节点
        RandomListNode oldList = head;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = new RandomListNode(head.label);
            head.next.next = temp;
            head = temp;
        }
        //2. 复制原链表的随机指针
        head = oldList;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        //3. 拆出原链表和复制的链表
        RandomListNode newList = oldList.next;
        head = oldList;
        RandomListNode newHead = oldList.next;
        while (head != null && newHead != null) {
            RandomListNode temp = head.next.next;
            head.next = temp;
            if (temp != null) {
                newHead.next = temp.next;
            } else {
                break;
            }
            head = temp;
            newHead = temp.next;
        }
        return newList;
    }
}
