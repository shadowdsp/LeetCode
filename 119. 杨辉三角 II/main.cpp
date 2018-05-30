class Solution {
public:
    vector<int> getRow(int rowIndex) {
        int dp[2][rowIndex+1];
        memset(dp, 0, sizeof dp);
        int now = 0, pre = 1;
        dp[1][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            dp[now][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[now][j] = dp[pre][j-1] + dp[pre][j];
            }
            now ^= 1;
            pre ^= 1;
        }
        vector<int> ans;
        for (int i = 0; i <= rowIndex; i++) {
            ans.push_back(dp[pre][i]);
        }
        return ans;
    }
};