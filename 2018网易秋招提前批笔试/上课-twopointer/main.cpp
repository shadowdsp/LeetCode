#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 11;

int n, k;
int a[N], t[N], sum[N];
int main() {
    cin >> n >> k;
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    for (int i = 1; i <= n; i++) scanf("%d", &t[i]);
    int now = 0, ans = 0, mx = -1;
    int l = 1, r = 1;
    while (r <= n) {
        if (!t[r]) {
            now += a[r];
        } else {
            ans += a[r];
        }
        while (r - l + 1 > k) {
            if (!t[l]) {
                now -= a[l];
            }
            l++;
        }
        if (now > mx) mx = now;
        r++;
    }
    cout << mx + ans << endl;

    return 0;
}