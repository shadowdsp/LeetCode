#include <bits/stdc++.h>
using namespace std;
// 完全背包
class Solution {
public:
    int numSquares(int n) {
        int dp[n+1];
        memset(dp, 0x3f3f3f3f, sizeof dp);
        dp[0] = 0;
        int m = 1;
        while (m * m < n) m++;
        for (int i = 1; i <= m; i++) 
            for (int j = i * i; j <= n; j++) 
                dp[j] = min(dp[j-i*i] + 1, dp[j]);
        return dp[n];
    }
};