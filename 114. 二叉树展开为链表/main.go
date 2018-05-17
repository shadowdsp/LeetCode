/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func flatten(root *TreeNode)  {
    if root == nil {
        return 
    }
    dfs(root)
}

func dfs(rt *TreeNode) *TreeNode {
    tmp := rt.Right
    if rt.Left != nil {
        c := dfs(rt.Left)
        rt.Right = rt.Left
        rt.Left = nil
        c.Right = tmp
    }
    if rt.Right != nil {
        return dfs(rt.Right)
    }
    return rt
}