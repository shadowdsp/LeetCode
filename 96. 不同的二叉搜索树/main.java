class Solution {
    public int numTrees(int n) {
        // 发现左右是子状态，因此可以用dp记录状态
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i-j] * dp[j-1];
            }
        }
        return dp[n];
    }
}