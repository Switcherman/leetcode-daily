/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getNode(nums, 0, nums.length - 1);
    }
    private TreeNode getNode(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int index = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = getNode(nums, begin, index - 1);
        root.right = getNode(nums, index + 1, end);
        return root;
    }
}
// @lc code=end

