/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            while (cur.next != null && cur.next.val == temp.val) {
                cur = cur.next;
            }
            temp.next = cur.next;
            cur = temp.next; 
        }
        return dummyhead.next;
    }
}
// @lc code=end

