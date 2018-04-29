import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        int n = lists.length;
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                que.add(lists[i]);
            }
        }
        ListNode now = head;
        while (true) {
            if (que.size() == 0) break;
            ListNode node = que.poll();
            now.next = node;
            now = now.next;
            if (node.next != null) que.offer(node.next);
        }
        now.next = null;
        return head.next;
    }
}