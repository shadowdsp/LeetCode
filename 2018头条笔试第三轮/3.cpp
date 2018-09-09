// IP还原
#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 1e5 + 11;
string s;
int ans = 0;

int t(int c) {
    return s[c] - '0';
}

void dfs(int id, int n, int sum, int cnt, bool zero) {
    if (id > n) {
        if (sum <= 255 && cnt == 4) {
            ans++;
        }
        return ;
    }
    if (cnt > 4 || sum > 255 || n - id < 4 - cnt - 1) {
        return ;
    }
    if (id > 0 && !zero) dfs(id + 1, n, sum * 10 + t(id), cnt, false);
    dfs(id + 1, n, t(id), cnt + 1, t(id) == 0);
}

int main() {
    cin >> s;
    dfs(0, s.length() - 1, 0, 0, false);
    cout << ans << endl;
    return 0;
}

/*
255255255255
1001101
 10001
*/