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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while (now != null || !stack.isEmpty()) {
            if (now != null) {
                stack.push(now);
                now = now.left;
            } else {
                now = stack.pop();
                if ((--k) == 0) return now.val;
                now = now.right;
            }
        }
        return 0;
    }
}