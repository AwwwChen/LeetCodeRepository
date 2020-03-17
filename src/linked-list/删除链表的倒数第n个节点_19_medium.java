import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
//解法二：快慢指针法，两个指针让它们间隔n个节点
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode tail = dummyHead;
        int count = 0;
        while (tail != null) {
            if (count == n + 1) {
                cur = cur.next;
            } else {
                count ++;
            }
            tail = tail.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }
}

//解法一：  开辟一个数组记录链表中的引用
//         可以使用一个虚拟头节点，注意返回的是虚拟头节点.next，不要返回head。因为有可能要求删除头节点。
class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = dummyHead;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        ListNode prev = nodes.get(nodes.size() - n - 1);
        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        return dummyHead.next;
    }
}
// @lc code=end

