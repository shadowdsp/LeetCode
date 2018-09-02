class Solution {
    public boolean isMatch(String s, String p) {
        char[] s1 = s.toCharArray();
        char[] s2 = p.toCharArray();
        int n = s1.length, m = s2.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        int st = 0;
        for (int i = 1; i <= m; i++) {
            if (s2[i-1] == '*') {
                dp[i][0] = dp[i-1][0];
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j] || dp[i][j];
                }
            } else {
                st++;
                for (int j = st; j <= n; j++) {
                    if (s2[i-1] == '?' || s1[j-1] == s2[i-1]) {
                        dp[i][j] = dp[i-1][j-1] || dp[i][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}