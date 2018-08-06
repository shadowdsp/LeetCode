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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<TreeNode> dep = new ArrayList<>();
            int mx = que.peek().val;
            while (!que.isEmpty()) {
                dep.add(que.poll());
                mx = Math.max(mx, dep.get(dep.size() - 1).val);
            }
            for (TreeNode now : dep) {
                if (now.left != null) que.offer(now.left);
                if (now.right != null) que.offer(now.right);
            }
            ans.add(mx);
        }
        return ans;
    }
}