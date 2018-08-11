#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 11;

int n;
int a[N], sum[N];
int m;
int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> a[i], sum[i] = sum[i-1] + a[i];
    }
    cin >> m;
    while (m--) {
        int q;
        cin >> q;
        int l = 1, r = n, ans = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (sum[mid] >= q) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        cout << ans << endl;
    }
    return 0;
}