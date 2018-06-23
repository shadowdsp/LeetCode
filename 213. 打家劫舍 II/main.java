class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i][1] = dp[i-1][0] + nums[i];
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        dp[n-1][0] = 0;
        dp[n-1][1] = nums[n-1];
        ans = Math.max(ans, nums[n-1]);
        for (int i = n - 2; i > 0; i--) {
            dp[i][1] = dp[i+1][0] + nums[i];
            dp[i][0] = Math.max(dp[i+1][0], dp[i+1][1]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}