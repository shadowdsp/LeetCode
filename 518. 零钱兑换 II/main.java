class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        int n = coins.length;
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[j] = j - coins[i] >= 0 ? dp[j] + dp[j-coins[i]] : dp[j];
            }
        }
        return dp[amount];
    }
}