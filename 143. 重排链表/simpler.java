/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return ;
        ListNode cur = head, rev = head, slow = head, fast = head;
        // 找长度并分割链表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        rev = slow.next;
        slow.next = null;
        // 翻转
        ListNode pre = null;
        while (rev != null) {
            ListNode nxt = rev.next;
            rev.next = pre;
            pre = rev;
            rev = nxt;
        }
        // 合并
        rev = pre;
        cur = head;
        int cnt = 1;
        ListNode seq = head.next;
        while (seq != null && rev != null) {
            ListNode nxt = null;
            if (cnt % 2 == 0) {
                cur.next = seq;
                seq = seq.next;
            } else {
                cur.next = rev;
                rev = rev.next;
            }
            cnt++;
            cur = cur.next;
        }
        if (seq != null) cur.next = seq;
        if (rev != null) cur.next = rev;
    }
}