/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode p;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        p = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int ans = p.val;
        ListNode head = p;
        Random random = new Random();
        for (int i = 0; head != null; i++, head = head.next) 
            if (random.nextInt(i+1) == i) ans = head.val;
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */