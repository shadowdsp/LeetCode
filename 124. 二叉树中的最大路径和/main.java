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
	int ans;
    public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
        ans = root.val;
        dfs(root);
		return ans;
	}
	
	int dfs(TreeNode u) {
		if (u == null) {
			return 0;
		}
		int l = Math.max(dfs(u.left), 0), r = Math.max(dfs(u.right), 0);
		if (l + r + u.val > ans) {
			ans = l + r + u.val;
		}
		return (l > r ? l : r) + u.val;
	}
}