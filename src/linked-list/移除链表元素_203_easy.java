/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}

class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        } 
        ListNode result = removeElements(head.next, val);
        if (head.val == val) {
            return result;
        } else {
            head.next = res;
            return head;
        }
    }

}

// 增加虚拟头节点的解法
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    // public static void main(String[] args) {
    //     int[] nums = {1, 2, 3, 4, 5 ,6};
    //     ListNode head = new ListNode(nums);
    //     System.out.println(new Solution().removeElements(head, 6));
    // }

    // public class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode(int x) { val = x; }
    //     ListNode(int[] arr) {
    //         this.val = arr[0];
    //         ListNode cur = this;
    //         for(int i = 1; i < arr.length; i ++) {
    //             cur.next = new ListNode(arr[i]);
    //         }
    //     }

    //     @Override
    //     public String toString() {
    //         StringBuilder res = new StringBuilder();
    //         ListNode cur = this;
    //         while (cur != null) {
    //             res.append(cur.val + " ");
    //         }
    //         return res.toString();
    //     }
    // }
}
// @lc code=end

