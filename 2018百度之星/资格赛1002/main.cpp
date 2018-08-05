#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 11;

int sum[N][26];
string str;

int main() {
    int t;
    scanf("%d", &t);
    for (int cas = 1; cas <= t; cas++) {
        int n, q;
        scanf("%d%d", &n, &q);
        cin >> str;
        memset(sum, 0, sizeof sum);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i-1][j];
            }
            sum[i][str[i-1]-'A']++;
        }
        printf("Case #%d:\n", cas);
        while (q--) {
            int l, r;
            scanf("%d%d", &l, &r);
            for (int i = 0; i < 26; i++) {
                if (sum[r][i] - sum[l-1][i] > 0) {
                    printf("%d\n", sum[r][i] - sum[l-1][i]);
                    break;
                }
            }
        }
    }
    return 0;
}