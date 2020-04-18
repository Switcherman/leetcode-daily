/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 复制节点
        Node oldHead = head;
        while (head != null) {
            Node node = new Node(head.val);
            Node temp = head.next;
            head.next = node;
            node.next = temp;
            head = temp;
        }
        // 复制随机指针
        head = oldHead;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        // 拆分链表
        Node newHead = oldHead.next;
        head = oldHead;
        Node result = head.next;
        while (head != null) {
            head.next = head.next.next;
            newHead.next = newHead.next != null ? newHead.next.next : null;
            head = head.next;
            newHead = newHead.next;
        }
        return result;
    }
}
// @lc code=end

