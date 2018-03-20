#include <bits/stdc++.h>
using namespace std;
// 爆搜
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
        int n = nums.size();
        return dfs(S - nums[n-1], n - 2, nums) + dfs(S + nums[n-1], n - 2, nums);
    }
    
    int dfs(int sum, int dep, vector<int>& nums) {
        if (dep < 0) return sum == 0;
        return dfs(sum - nums[dep], dep - 1, nums) + dfs(sum + nums[dep], dep - 1, nums);
    }
};

// 背包滚动数组，偏移m使得可以计算负数
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
        int n = nums.size();
        int m = 0;
        for (int i = 0; i < n; i++) m += nums[i];
        int sum = m * 2;
        int dp[2][sum+1];
        int pre = 0, now = 1;
        memset(dp[pre], 0, sizeof(dp[pre]));
        dp[pre][m] = 1;
        for (int i = 0; i < n; i++) {
            memset(dp[now], 0, sizeof(dp[now]));
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i]) dp[now][j] += dp[pre][j-nums[i]];
                if (j <= sum - nums[i]) dp[now][j] += dp[pre][j+nums[i]];
            }
            now ^= 1; pre ^= 1;
        }
        if (S > m || S < -m) return 0;
        return dp[pre][S+m];
    }
};