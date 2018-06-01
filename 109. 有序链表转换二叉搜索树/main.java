/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        if (head == null) {
            return null;
        }
        return dfs(head, null);
    }
    
    TreeNode dfs(ListNode l, ListNode r) {
        if (l == r) {
            return null;
        }
        ListNode slow = l, fast = l;
        while (fast != r && fast.next != r) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode now = new TreeNode(slow.val);
        now.left = dfs(l, slow);
        now.right = dfs(slow.next, r);
        return now;
    }
}