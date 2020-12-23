class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int n = matrix.size();
        if (n <= 0) {
            return 0;
        }
        int m = matrix[0].size();
        if (m <= 0) {
            return 0;
        }
        int sum[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] = 0;
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].size(); j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        sum[i][j] = 1;
                    } else {
                        sum[i][j] = min(sum[i-1][j], min(sum[i][j-1], sum[i-1][j-1])) + 1;
                    }
                    ret = max(ret, sum[i][j]);
                }
            }
        }
        return ret * ret;
    }
};
