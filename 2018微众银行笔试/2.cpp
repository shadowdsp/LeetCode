#include <bits/stdc++.h>

using namespace std;
typedef long long LL;
const int N = 1011;
int a[6];

int main() {
    for (int i = 0; i < 6; i++) {
        scanf("%d", &a[i]);
    }
    LL ans = 0;

    // 使用6
    ans += a[5];

    // 使用5
    ans += a[4];
    a[0] -= min(a[0], (36 - 25) * a[4]);

    // 使用4
    ans += a[3];
    for (int i = 0; i < a[3]; i++) {
        int rev = 5 * 4;
        while (a[1] > 0 && rev > 0) {
            a[1]--;
            rev -= 4;
        }
        a[0] -= min(rev, a[0]);
    }

    // 使用3
    ans += (a[2] + 3) / 4;
    int rev = a[2] % 4;
    if (rev == 1) {
        a[0] -= min(a[0], 36 - 9 * rev - 4 * min(a[1], 5));
        a[1] -= min(a[1], 5);
    } else if (rev == 2) {
        a[0] -= min(a[0], 36 - 9 * rev - 4 * min(a[1], 3));
        a[1] -= min(a[1], 3);
    } else if (rev == 3) {
        a[0] -= min(a[0], 36 - 9 * rev - 4 * min(a[1], 1));
        a[1] -= min(a[1], 1);
    }

    // 剩下2的
    ans += max(0, (a[1] + 8) / 9);
    rev = a[1] % 9 == 0 ? 0 : 36 - a[1] % 9 * 4;
    a[0] -= min(a[0], rev);

    ans += max(0, a[0] / 36);
    cout << ans << endl;
    return 0;
}

/*
5 5
4 2
2 3
3 1
1 2
3 5
*/