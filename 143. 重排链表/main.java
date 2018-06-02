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
        ListNode cur = head, rev = head;
        // 找长度
        int n = 1;
        while (rev.next != null) {
            rev = rev.next;
            n++;
        }
        // 找分割点
        int cnt = (n + 1) / 2 - 1;
        while (cnt > 0) {
            cur = cur.next;
            cnt--;
        }
        // 翻转
        rev = cur.next;
        ListNode pre = null;
        cur.next = null;
        while (rev != null) {
            ListNode nxt = rev.next;
            rev.next = pre;
            pre = rev;
            rev = nxt;
        }
        // 合并
        rev = pre;
        cur = head;
        cnt = 1;
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