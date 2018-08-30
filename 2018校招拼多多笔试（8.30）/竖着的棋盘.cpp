#include <bits/stdc++.h>
using namespace std;

char mp[11][11];

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) scanf("%s", mp[i] + 1);
    for (int i = 1; i <= m; i++) {
        int pre = 1;
        for (int j = 1; j <= n; j++) {
            if (mp[j][i] == 'x') {
                int cnt = 0;
                for (int k = pre; k < j; k++) {
                    if (mp[k][i] == 'o') {
                        cnt++;
                        mp[k][i] = '.';
                    }
                }
                for (int k = j - 1; cnt > 0 && k >= pre; k--) {
                    mp[k][i] = 'o';
                    cnt--;
                }
                pre = j + 1;
            }
        }
        for (int j = pre; j <= n; j++) {
            mp[j][i] = '.';
        }
    }
    for (int i = 1; i <= n; i++) {
        printf("%s\n", mp[i] + 1);
    }
    return 0;
}