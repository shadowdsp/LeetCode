// 组织优化
#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 1e5 + 11;

bool vis[1111][1111];
int mp[1111][1111];
int n, dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1};

void dfs(int x, int y) {
    mp[x][y] = 0;
    for (int k = 0; k < 4; k++) {
        int nx = dx[k] + x, ny = dy[k] + y;
        if (1 <= nx && nx <= n && 1 <= ny && ny <= n && mp[nx][ny]) {
            dfs(nx, ny);
        }
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> mp[i][j];
        }
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (mp[i][j]) {
                dfs(i, j);
                ans++;
            }
        }
    }
    cout << ans << endl;
    return 0;
}