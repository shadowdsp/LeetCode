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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return dfs(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    
    TreeNode dfs(int[] in, int l1, int r1, int[] post, int l2, int r2) {
        if (r1 < l1) {
            return null;
        } else if (r1 == l1) {
            return new TreeNode(in[l1]);
        }
        TreeNode now = new TreeNode(post[r2]);
        int limit = l1;
        for (int i = l1; i <= r1; i++) {
            if (in[i] == post[r2]) {
                limit = i;
                break;
            }
        }
        now.left = dfs(in, l1, limit - 1, post, l2, l2 + (limit - l1 - 1));
        now.right = dfs(in, limit + 1, r1, post, l2 + limit - l1, r2 - 1);
        return now;
    }
}