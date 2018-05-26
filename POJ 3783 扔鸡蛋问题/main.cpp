#include <cstdio> 
#include <cstring>
#include <iostream>
#include <algorithm>
using namespace std;
const int N = 1011;
const int M = 51;
const int INF = 0x3f3f3f3f;
int dp[N][M];

int main() {
    int T;
    scanf("%d", &T);
    while (T--) {
        int t, n, m;
        scanf("%d%d%d", &t, &m, &n);
        memset(dp, 0, sizeof dp);
        // 楼层丢鸡蛋问题
        // dp[i][j]表示有i层楼j颗鸡蛋的最少次数
        // 一颗鸡蛋的情况下有n层楼一共需要n次
        for (int i = 1; i <= n; i++)
            dp[i][1] = i;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m && j <= n; j++) {
                int num = INF;
                for (int k = 1; k <= i; k++) {
                    // 在当前的时刻，如果在第k层楼扔下鸡蛋碎了，那么剩下k-1层楼和j-1颗
                    // 鸡蛋，如果没有碎，还剩下i-k层楼和j颗鸡蛋
                    // max保证是在最坏的情况下，min保证是挑选最优解
                    num = min(num, max(dp[k-1][j-1], dp[i-k][j]) + 1);
                }
                dp[i][j] = num;
            }
        }
        printf("%d %d\n", t, dp[n][m]);
    }
    return 0;
}
