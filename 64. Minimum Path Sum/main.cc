class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int dp[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0xfffffff;
            }
        }
        dp[0][1] = dp[1][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = min(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[n][m];
    }
};