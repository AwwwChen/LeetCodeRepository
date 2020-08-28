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
 *     TreeNode(int x) { val = x; }
 * }
 */
// 解法一：以中间节点作为根节点：数组左边的元素，数组右边的元素，分别作为左右子树
// 递归执行相同操作即可
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return core(nums, 0, nums.length);
    }

    private TreeNode core(int[] nums, int s, int t) {
        if (s >= t) return null;
        int m = (s + t) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = core(nums, s, m);
        root.right = core(nums, m + 1, t);
        return root;
    }
}
// @lc code=end

