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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode now = null;
        while (!que.isEmpty()) {
            now = que.poll();
            if (now.right != null) {
                que.offer(now.right);
            }
            if (now.left != null) {
                que.offer(now.left);
            }
        }
        return now.val;
    }
}