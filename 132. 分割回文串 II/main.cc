// dp
// f[i] 表示由 i 到 n-1 组成回文串最少需要分割多少次，最后 f[0] 就是答案。
// 分为三种情况：
// 1. i~n-1 本身是回文串，f[i] = 0;
// 2. i 自己分割成一个回文串，f[i] = f[i+1] + 1;
// 3. i 和后面的某个子串组合成一个回文串，即 i~j 是一个回文串，则有 f[i] = f[j] + 1 (i<j<n).
// 因此预处理出快速判断回文串的数组，就可以 O(n^2) 处理了。

class Solution {
private:
    vector<vector<int>> dp;
    vector<int> f;
    int n;

public:
    int minCut(string s) {
        n = s.length();
        dp.assign(n, vector<int>(n, 1));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s[i] == s[j] && dp[i+1][j-1] == 1);
            }
        }

        f.assign(n, 0x3f3f3f3f);
        f[n-1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (dp[i][n-1]) {
                f[i] = 0;
                continue;
            }
            f[i] = min(f[i], f[i+1] + 1);
            for (int j = i + 1; j < n; j++) {
                if (dp[i][j-1]) {
                    f[i] = min(f[i], f[j] + 1);
                }
            }
        }
        return f[0];
    }
};