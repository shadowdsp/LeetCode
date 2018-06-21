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
        Stack<TreeNode> sta = new Stack<>();
        Stack<Integer> val = new Stack<>();
        sta.push(root);
        while (!sta.isEmpty()) {
            TreeNode rt = sta.pop();
            if (rt == null) continue;
            val.push(rt.val);
            sta.push(rt.left);
            sta.push(rt.right);
        }
        while (!val.isEmpty()) ans.add(val.pop());
        return ans;
    }
}