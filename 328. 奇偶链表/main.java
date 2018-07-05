/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        int cnt = 0;
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        a.next = head;
        b.next = head.next;
        ListNode p = a;
        ListNode q = b;
        while (p.next != null || q.next != null) {
            if (cnt % 2 == 0) {
                p = p.next;
                if (q != null && q.next != null) p.next = q.next.next;
            } else {
                q = q.next;
                if (p != null && p.next != null) q.next = p.next.next;
            }
            cnt++;
        }
        p.next = b.next;
        return a.next;
    }
}