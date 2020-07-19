func maxCoins(nums []int) int {
    n := len(nums)
    val := make([]int, n + 2)
    for i := 1; i <= n; i++ {
        val[i] = nums[i-1]
    }
    val[0], val[n+1] = 1, 1
    dp := make([][]int, n + 2)
    for i := 0; i <= n + 1; i++ {
        dp[i] = make([]int, n + 2)
    }
    for l := n - 1; l >= 0; l-- {
        for r := l + 2; r <= n + 1; r++ {
            for k := l + 1; k < r; k++ {
                sum := val[k] * val[l] * val[r]
                sum += dp[l][k] + dp[k][r]
                if sum > dp[l][r] {
                    dp[l][r] = sum
                }
            }
        }
    }
    return dp[0][n+1]
}