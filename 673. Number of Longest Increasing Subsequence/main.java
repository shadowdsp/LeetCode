class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] sum = new int[n];
        int ans = 0, mx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = sum[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) { // 已经被初始化，加上
                        sum[i] += sum[j];
                    } else if (dp[i] < dp[j] + 1) { // 未被初始化，赋值
                        dp[i] = dp[j] + 1;
                        sum[i] = sum[j];
                    }
                }
            }
            if (mx < dp[i]) {
                mx = dp[i];
                ans = 0;
            }
            if (mx == dp[i])
                ans += sum[i];
        }
        return ans;
    }
}