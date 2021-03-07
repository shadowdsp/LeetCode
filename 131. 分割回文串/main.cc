// dp[i][j] 表示 s[i,j] 是否为回文串
// 转移方程：dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
// dfs回溯+记忆化搜索
class Solution {
private:
    vector<vector<int>> dp;
    vector<vector<string>> ret;
    vector<string> ans; 
    int n;

public:
    int isPalindrome(const string& s, int i, int j) {
        if (dp[i][j]) {
            return dp[i][j];
        }
        if (i >= j) {
            return 1;
        }
        return dp[i][j] = ((s[i] == s[j]) ? isPalindrome(s, i+1, j-1) : -1);
    }

    void dfs(const string& s, int i) {
        if (i == n) {
            ret.push_back(ans);
            return ;
        }
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j) == 1) {
                ans.push_back(s.substr(i, j - i + 1));
                dfs(s, j + 1);
                ans.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        n = s.size();
        dp.assign(n, vector<int>(n));
        dfs(s, 0);
        return ret;
    }
};