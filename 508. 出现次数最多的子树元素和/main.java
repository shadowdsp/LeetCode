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
    HashMap<Integer, Integer> map;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        int mx = -1;
        for (int num : map.values()) {
            if (num > mx) {
                mx = num;
            }
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mx) {
                cnt++;
            }
        }
        int[] ans = new int[cnt];
        cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mx) {
                ans[cnt++] = entry.getKey();
            }
        }
        return ans;
    }

    int dfs(TreeNode rt) {
        if (rt == null) return 0;
        int sum = rt.val + dfs(rt.left) + dfs(rt.right);
        if (!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        }
        return sum;
    }
}