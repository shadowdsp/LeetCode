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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int cnt = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int dep = 0;
        while (!que.isEmpty()) {
            dep++;
            int tmp = 0;
            List<Integer> now = new ArrayList<>();
            while (cnt > 0) {
                TreeNode node = que.poll();
                cnt--;
                now.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                    tmp++;
                }
                if (node.right != null) {
                    que.offer(node.right);
                    tmp++;
                }
            }
            if (dep % 2 == 0) {
                Collections.reverse(now);
            }
            ans.add(now);
            cnt = tmp;
        }
        return ans;
    }
}