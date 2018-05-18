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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode rt, int sum) {
        int now = sum * 10 + rt.val;
        if (rt.left == null && rt.right == null) {
            return now;
        }
        int ans = 0;
        if (rt.left != null) {
            ans += dfs(rt.left, now);
        }
        if (rt.right != null) {
            ans += dfs(rt.right, now);
        }
        return ans;
    }
}