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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = calLeft(root);
        int rh = calRight(root);
        if (lh == rh) return (1 << lh) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    int calLeft(TreeNode rt) {
        int h = 0;
        while (rt != null) {
            rt = rt.left;
            h++;
        }
        return h;
    }
    
    int calRight(TreeNode rt) {
        int h = 0;
        while (rt != null) {
            rt = rt.right;
            h++;
        }
        return h;
    }
}