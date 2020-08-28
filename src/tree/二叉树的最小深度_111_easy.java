import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
// 解法一：层次遍历找到一个没有子节点的节点，返回深度
// 层次遍历时需要记录深度，可以引入哨兵节点
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 1;
        queue.add(root);
        // 每层末尾加入哨兵节点
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                queue.add(null);
                maxDepth ++;
                continue;
            }
            if (temp.left == null && temp.right == null) {
                return maxDepth;
            } else {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
           
        }
        return maxDepth;
    }
}
// @lc code=end

