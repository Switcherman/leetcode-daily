/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 层序遍历
        List<Node> temp = new ArrayList<>();
        temp.add(root);
        order(temp);
        return root;
    }

    private void order(List<Node> list) {
        if (list.size() == 0) {
            return;
        }
        List<Node> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);                
            }
            if (i != list.size() - 1) {
                node.next = list.get(i + 1);
            }

        }
        order(temp);
    }

}
// @lc code=end

