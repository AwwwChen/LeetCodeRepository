/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
// 解法一：迭代方法实现，没有采用虚拟头节点，实现的比较繁琐，可以优化。
//        这里还考虑了链表是升序还是降序的，不过貌似是不用考虑的（默认都是升序的）。
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        // 默认升序
        boolean reverse = false;
        boolean isEqual = true;
        ListNode cur = l1;
        
        while (cur.next != null) {
            if (cur.val != cur.next.val) isEqual = false;
            if (cur.val > cur.next.val)
                reverse = true;
            cur = cur.next;
        }
        if (isEqual) {
            cur = l2;
            while (cur.next != null) {
                if (cur.val > cur.next.val)
                    reverse = true;
                cur = cur.next;
            }
        }
        ListNode res = null;
        ListNode other = null;
        // 降序
        if (reverse) {
            if (l1.val > l2.val) {
                cur = l1;
                res = l1;
                other = l2;
            } else {
                res = l2;
                cur = l2;
                other = l1;
            }
            ListNode prev = null;
            while (cur != null) {
                ListNode temp1 = null;
                ListNode temp2 = null;
                if (other.val <= cur.val && ( cur.next == null || other.val >= cur.next.val)) {
                    temp1 = cur.next;
                    temp2 = other;
                    other = other.next;
                    cur.next = temp2;
                    cur.next.next = temp1;
                    if (other == null) break;
                }
                if (cur.next == null) prev = cur;
                cur = cur.next;
            }
            if (other != null) prev.next = other;
            return res;
        // 升序
        } else {
            if (l1.val <= l2.val) {
                cur = l1;
                res = l1;
                other = l2;
            } else {
                res = l2;
                cur = l2;
                other = l1;
            }
            ListNode prev = null;
            while (cur != null) {
                ListNode temp1 = null;
                ListNode temp2 = null;
                if (other.val >= cur.val && ( cur.next == null || other.val <= cur.next.val)) {
                    temp1 = cur.next;
                    temp2 = other;
                    other = other.next;
                    cur.next = temp2;
                    temp2.next = temp1;
                    if (other == null) break;
                }
                if (cur.next == null) prev = cur;
                cur = cur.next;
            }
            if (other != null) prev.next = other;
            return res;
        }
    }
}
// @lc code=end

