/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func inorderTraversal(root *TreeNode) []int {
    ans := make([]int, 0)
    dfs(root, &ans)
    return ans
}

func dfs(rt *TreeNode, ans *[]int) {
    if rt == nil {
        return
    }
    dfs(rt.Left, ans)
    *ans = append(*ans, rt.Val)
    dfs(rt.Right, ans)
}