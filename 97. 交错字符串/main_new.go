func isInterleave(s1 string, s2 string, s3 string) bool {
    l1, l2, l3 := len(s1), len(s2), len(s3)
    if l1 + l2 != l3 {
        return false
    }
    dp := make([][]int, l1+1)
    for i := 0; i <= l1; i++ {
        dp[i] = make([]int, l2+1)
    }
    dp[0][0] = 1

	for i := 0; i <= l1; i++ {
		for j := 0; j <= l2; j++ {
			p := i + j - 1
			if i > 0 && dp[i-1][j] == 1 && s1[i-1] == s3[p] {
				dp[i][j] = 1
			}
			if j > 0 && dp[i][j-1] == 1 && s2[j-1] == s3[p] {
				dp[i][j] = 1
			}
		}
	}
	return dp[l1][l2] == 1
}