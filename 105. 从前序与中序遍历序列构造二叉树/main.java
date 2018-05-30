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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return dfs(preorder, 0, n-1, inorder, 0, n-1);
    }
    
    public TreeNode dfs(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        if (l1 == r1) {
            return new TreeNode(pre[l1]);
        } else if (r1 < l1) {
            return null;
        }
        int limit = 0;
        for (int i = l2; i <= r2; i++) {
            if (in[i] == pre[l1]) {
                limit = i;
                break;
            }
        }
        TreeNode now = new TreeNode(pre[l1]);
        now.left = dfs(pre, l1 + 1, l1 + limit - l2, in, l2, limit - 1);
        now.right = dfs(pre, l1 + limit - l2 + 1, r1, in, limit + 1, r2);
        return now;
    }
}