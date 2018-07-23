class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;
        dp[0][0] = 0;
        int ans = 0;
        for (int i = 0; i < strs.length; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    a++;
                } else {
                    b++;
                }
            }
            for (int j = m; j >= a; j--) {
                for (int k = n; k >= b; k--) {
                    if (dp[j-a][k-b] != -1) dp[j][k] = Math.max(dp[j][k], dp[j-a][k-b] + 1);
                    if (dp[j][k] > ans) ans = dp[j][k];
                }
            }
        }
        return ans;
    }
}