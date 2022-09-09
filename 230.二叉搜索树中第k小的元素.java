/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(list, root);
        return list.get(k - 1).val;
    }
    public void preOrder(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(list, root.left);
        list.add(root);
        preOrder(list, root.right);
        
    }
}
// @lc code=end

