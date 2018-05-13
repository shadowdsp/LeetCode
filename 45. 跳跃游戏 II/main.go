func jump(nums []int) int {
    n := len(nums)
    dp := make([]int, n + 1)
    for i := 1; i < n; i++ {
        dp[i] = n + 1
    }
    for i := 0; i < n; i++ {
        for j := 1; j <= nums[i]; j++ {
            if j + i < n && dp[j + i] > dp[i] + 1 {
                dp[j + i] = dp[i] + 1
            }
        }
    }
    return dp[n-1]
}