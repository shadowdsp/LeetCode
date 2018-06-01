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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return dfs(0, n - 1, nums);
    }
    
    TreeNode dfs(int l, int r, int[] nums) {
        if (l == r) {
            return new TreeNode(nums[l]);
        } else if (r < l) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode now = new TreeNode(nums[m]);
        now.left = dfs(l, m - 1, nums);
        now.right = dfs(m + 1, r, nums);
        return now;
    }
}