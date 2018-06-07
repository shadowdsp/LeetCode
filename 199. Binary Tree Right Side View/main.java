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
    public List<Integer> rightSideView(TreeNode root) {
        int dep = dfs(root, 0);
        Integer[] vis = new Integer[dep];
        find(root, vis, 0);
        return Arrays.asList(vis);
    }
    
    int dfs(TreeNode rt, int dep) {
        if (rt == null) return dep;
        return Math.max(dfs(rt.left, dep + 1), dfs(rt.right, dep + 1));
    }
    
    void find(TreeNode rt, Integer[] vis, int dep) {
        if (rt == null) return ;
        find(rt.left, vis, dep + 1);
        find(rt.right, vis, dep + 1);
        vis[dep] = rt.val;
    }
}