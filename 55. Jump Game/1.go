func canJump(nums []int) bool {
    n := len(nums)
    vis := make([]bool, n)
    vis[0] = true
    for i := 0; i < n; i++ {
        if vis[i] {
            for j, c := i + 1, 0; c < nums[i] && j < n; j, c = j + 1, c + 1 {
                vis[j] = true
            }
        }
    }
    return vis[n-1]
}