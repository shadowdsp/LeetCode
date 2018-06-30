class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 0) return 0;
        int ans = -1;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            if (i >= 2) dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            else dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}