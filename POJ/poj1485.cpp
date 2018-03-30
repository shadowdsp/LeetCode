#include <cstdio>
#include <cstring>
#include <cstdlib>
using namespace std;
const int N = 211;
const int INF = 0x3f3f3f3f;
int n, m, x[N], dp[N][N], cost[N][N];
int st[N][N], ed[N][N], id[N][N];

void dfs(int i, int j) {
    if (i < 1 || j < 1) return ;
    dfs(st[i][j]-1, j-1);
    printf("Depot %d at restaurant %d serves ", j, id[i][j]);
    if (st[i][j] == ed[i][j]) printf("restaurant %d\n", st[i][j]);
    else printf("restaurants %d to %d\n", st[i][j], ed[i][j]);
}

int main() {
    int t = 0;
    while (scanf("%d%d", &n, &m) && n && m) {
        for (int i = 1; i <= n; i++) scanf("%d", &x[i]);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                cost[i][j] = 0;
                for (int k = i; k <= j; k++)
                    cost[i][j] += abs(x[k] - x[(i+j)/2]);
            }
        }
        memset(dp, INF, sizeof dp);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) { // 枚举当前要放多少个包裹
            for (int j = 1; j <= i && j <= m; j++) { // 枚举仓库，要求仓库的数量比包裹数量少
                for (int k = j; k <= i; k++) {
                    // 枚举从第k个包裹到第i个包裹全都放到最后一个仓库，
                    // 而且满足前面的j-1个仓库都至少一个包裹
                    int now = dp[k-1][j-1] + cost[k][i];
                    if (dp[i][j] > now) {
                        dp[i][j] = now;
                        st[i][j] = k; ed[i][j] = i; // st,ed 分别记录最后一个仓库的起点和终点
                        id[i][j] = (k + i) / 2; // id 记录的是位置
                    }
                }
            }
        }
        printf("Chain %d\n", ++t);
        dfs(n, m);
        printf("Total distance sum = %d\n\n", dp[n][m]);
    }
    return 0;
}