/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
// 解法一：一对指针分别执行要交换的两两节点的开始与结束，在更新这对指针的时候判断是否到底。使用了虚拟头节点方便返回。
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode iter = head.next.next;
        for (;;) {
            ListNode l1 = cur.next;
            ListNode l2 = cur.next.next;
            cur.next = l2;
            l1.next = l2.next;
            l2.next = l1;
            if (iter == null || iter.next == null)  
                break;
            else {
                iter = iter.next.next;
                cur = cur.next.next;
            }
        }
        return dummyHead.next;
    }
}
// @lc code=end

