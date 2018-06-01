/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        if (cur == null) return head;
        while (cur.next != null) cur = cur.next;
        return mergeSort(head, cur);
    }
    
    ListNode mergeSort(ListNode l, ListNode r) {
        if (l == r) return new ListNode(l.val);
        ListNode slow = l, fast = l;
        while (fast != r && fast.next != r) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode s1 = mergeSort(l, slow);
        ListNode s2 = mergeSort(slow.next, r);
        return solve(s1, s2);
    }
    
    ListNode solve(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int val1 = a.val, val2 = b.val;
        if (val1 < val2) {
            a.next = solve(a.next, b);
            return a;
        } else {
            b.next = solve(a, b.next);
            return b;
        }
    }
}