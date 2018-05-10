/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
const MaxInt = int(^uint(0) >> 1) 
const MinInt = -MaxInt - 1

var ans = true
func isValidBST(root *TreeNode) bool {
    ans = true
    if root == nil {
        return true
    }
    dfs(root, MinInt, MaxInt)
    return ans
}

func dfs(root *TreeNode, mi int, mx int) {
    if root == nil || !ans {
        return
    }
    if mi >= root.Val || root.Val >= mx {
        ans = false
    }
    dfs(root.Left, mi, root.Val)
    dfs(root.Right, root.Val, mx)
}