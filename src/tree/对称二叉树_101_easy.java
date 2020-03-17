/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
// 解法三：使用队列队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
// 最初，队列中包含的是 root 以及 root。该算法的工作原理类似于BFS，但存在一些关键差异。
// 每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。
// 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。

// 此解法还有一个陷阱，考虑下面这种树：
//        7
//      /   \
//     7     7
//    / \   /
//   7   7 7
// 它按照上述解法将得到true的返回，但是它很明显是不对称的，所以我们需要把null节点也考虑进去：
//         7
//      /     \
//     7       7
//    / \     / \
//   7   7   7  null
//  / \ / \ / \
//nullnullnullnull
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (queue.size() == 1) return false;
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) return false;
            if (t1 == null && t2 == null) continue;
            if (t1.val != t2.val) return false;
            else {
                queue.offer(t1.right);
                queue.offer(t2.left);
                queue.offer(t1.left);
                queue.offer(t2.right);
            }
        }
        return true;
    }
}
// @lc code=end

// 解法二：前序遍历（先左子树再右子树）的结果等于中序遍历（先右子树再左子树）的一种简洁写法
// 此解法还有一个陷阱，考虑下面这种树：
//        7
//      /   \
//     7     7
//    / \   /
//   7   7 7
// 它按照上述解法将得到true的返回，但是它很明显是不对称的，所以我们需要把null节点也考虑进去：
//         7
//      /     \
//     7       7
//    / \     / \
//   7   7   7  null
//  / \ / \ / \
//nullnullnullnull
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root, root);
    }

    private boolean isSymmetricCore(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 == null && node2 != null) return false;
        else if (node1 != null && node2 == null) return false;

        if(node1.val == node2.val) {
            return isSymmetricCore(node1.left, node2.right) && isSymmetricCore(node1.right, node2.left);
        } else {
            return false;
        }
    }

}


// 解法一：前序遍历（先左子树再右子树）的结果等于中序遍历（先右子树再左子树）
// 此解法还有一个陷阱，考虑下面这种树：
//        7
//      /   \
//     7     7
//    / \   /
//   7   7 7
// 它按照上述解法将得到true的返回，但是它很明显是不对称的，所以我们需要把null节点也考虑进去：
//         7
//      /     \
//     7       7
//    / \     / \
//   7   7   7  null
//  / \ / \ / \
//nullnullnullnull
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        isSymmetricCoreLeftRight(root, list1);
        isSymmetricCoreRightLeft(root, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i ++) {
            if (list1.get(i) == null && list2.get(i) == null) continue;
            if (list1.get(i) == null && list2.get(i) != null) return false;
            if (list2.get(i) == null && list1.get(i) != null) return false;
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    private void isSymmetricCoreLeftRight(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node.val);
        isSymmetricCoreLeftRight(node.left, list);
        isSymmetricCoreLeftRight(node.right, list);
    }

    private void isSymmetricCoreRightLeft(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node.val);
        isSymmetricCoreRightLeft(node.right, list);
        isSymmetricCoreRightLeft(node.left, list);
    }
}