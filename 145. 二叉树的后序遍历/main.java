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
    List<Integer> ans;
    public List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
    
    void dfs(TreeNode rt) {
        if (rt == null) return ;
        dfs(rt.left);
        dfs(rt.right);
        ans.add(rt.val);
    }
}