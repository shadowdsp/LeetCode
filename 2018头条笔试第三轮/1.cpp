// 最大不重复子串
// 尺取
#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 1e5 + 11;

int vis[257];

int main() {
    string s;
    cin >> s;
    int n = s.length();
    memset(vis, 0, sizeof vis);
    int ans = 0, l = 0;
    for (int i = 0; i < n; i++) {
        vis[s[i]]++;
        while (vis[s[i]] > 1) {
            vis[s[l]]--;
            l++;
        }
        if (i - l + 1 > ans) ans = i - l + 1;
    }
    cout << ans << endl;
    return 0;
}