class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        if (matrix.size() <= 0 || matrix[0].size() <= 0) {
            return 0;
        }
        int n = matrix.size();
        int m = matrix[0].size();
        int dp[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 1;
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = min(dp[i][j-1], min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
};