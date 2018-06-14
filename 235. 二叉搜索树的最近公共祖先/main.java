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
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        dfs(root, p, q);
        return ans;
    }
    
    TreeNode dfs(TreeNode rt, TreeNode p, TreeNode q) {
        if (rt == null) return null;
        TreeNode a = dfs(rt.left, p, q);
        TreeNode b = dfs(rt.right, p, q);
        TreeNode pp = null, qq = null;
        if (a == p || b == p || rt == p) pp = p;
        if (a == q || b == q || rt == q) qq = q;
        if (pp != null && qq != null) {
            if (ans == null) ans = rt;
            return ans;
        }
        return pp == null ? qq : pp;
    }
}