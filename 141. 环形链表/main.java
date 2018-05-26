/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l = head, r = head;
        do {
            if (l.next != null && l.next.next != null) {
                l = l.next.next;
            } else {
                return false;
            }
            r = r.next;
        } while (l != r);
        return true;
    }
}