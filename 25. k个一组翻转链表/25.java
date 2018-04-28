/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode cur = head, nxt = cur.next, pre = head;
        boolean flag = false;
        while (cur != null) {
            ListNode tmp = cur, init = cur;
            int cnt = 0;
            while (tmp != null && cnt < k) {
                tmp = tmp.next;
                cnt++;
            }
            if (cnt == k) {
                cnt = 1;
                ListNode p = tmp, c = cur.next, cc;
                while (cnt < k) {
                    if (c != null) {
                        cc = c.next;
                    } else {
                        break;
                    }
                    cur.next = p;
                    p = cur;
                    c.next = cur;
                    cur = c;
                    c = cc;
                    cnt++;
                }
                if (!flag) {
                    flag = true;
                    head = cur;
                } else {
                    pre.next = cur;
                }
                cur = tmp;
            } else {
                break;
            }
            pre = init;
        }
        return head;
    }
}