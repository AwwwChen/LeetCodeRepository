import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 解法一：Top-Down递归方法
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(nodeDepth(root.right) - nodeDepth(root.left)) > 1) {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    private int nodeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = nodeDepth(node.left);
        int rightDepth = nodeDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
// @lc code=end

