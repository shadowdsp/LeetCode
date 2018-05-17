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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return ans;
        que.offer(root);
        int cnt = 1;
        while (!que.isEmpty()) {
            List<Integer> now = new ArrayList<>();
            int tmp = 0;
            while (cnt > 0) {
                TreeNode u = que.poll();
                now.add(u.val);
                cnt--;
                if (u.left != null) {
                    que.offer(u.left);
                    tmp++;
                } 
                if (u.right != null) {
                    que.offer(u.right);
                    tmp++;
                }
            }
            cnt = tmp;
            ans.add(now);
        }
        return ans;
    }
}