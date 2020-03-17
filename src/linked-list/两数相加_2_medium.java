/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
// 解法一: 
// 两个指针同步遍历链表l1和l2，使用一个变量记录进位，直到遍历到其中一个链表为null。
// 可能出现l1和l2数位不相等的情况，接着继续遍历剩下还没有遍历完的那个链表即可。
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = null;
        ListNode res = head;
        int temp = 0;
        while(l2 != null && l1 != null) {
            if ( l1.val + l2.val + temp < 10) {
                head.next = new ListNode(l2.val + l1.val + temp);
                temp = 0;
            } else {
                head.next = new ListNode((l1.val + l2.val + temp) % 10);
                temp = 1;
            }
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            cur = l2;
        } else if (l1 != null && l2 == null) {
            cur = l1;
        }

        while (cur != null) {
            if (cur.val + temp < 10) {
                head.next = new ListNode(cur.val + temp);
                temp = 0;
            } else {
                head.next = new ListNode((cur.val + temp) % 10);
                temp = 1;
            }
            head = head.next;
            cur = cur.next;
        }

        if (temp != 0) {
            head.next = new ListNode(1);
        }
        return res.next;
    }
}
// @lc code=end

