import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
// 解法三：递归时传入一个上界和一个下界，较麻烦
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    private static boolean isValid(TreeNode node, int lower, int higher) {
        if (node == null) return true;
        if (node.right != null && (node.right.val <= node.val || node.right.val > higher)) {
            return false;
        } else if (node.left != null && (node.left.val >= node.val || node.left.val < lower)) {
            return false;
        }
        return isValid(node.right,  node.val + 1, higher) && isValid(node.left, lower, node.val - 1);
    }
}

// @lc code=end

// 解法一：中序遍历看结果是否为升序
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.size() == 1) return true;
        for (int i = 1; i < list.size(); i ++) {
            if (list.get(i) <= list.get(i - 1)) 
                return false;
        }
        return true;
    }

    private void inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}

// 解法二（错误解法）：递归
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        } 
        if (root.right != null && root.right.val <= root.val) {
            return false;
        } else {
            return true;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}