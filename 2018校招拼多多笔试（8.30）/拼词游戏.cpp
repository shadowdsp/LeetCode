#include <bits/stdc++.h>
using namespace std;

const int N = 2011;
typedef unsigned long long ULL;
const int MOD = 1e7 + 7;
const int BASE = 233;

char ans[11];
char str[N][11];
vector<char> vec[11];
int n, m;
unordered_map<ULL, bool> mp;
bool flag;

void dfs(int id, ULL val) {
    if (id == m + 1 || flag) {
        if (!mp[val]) {
            flag = true;
        }
        return ;
    }
    for (int i = 0; i < vec[id].size() && !flag; i++) {
        if (flag) break;
        ans[id] = vec[id][i];
        dfs(id + 1, (val * BASE + (vec[id][i] - 'A')) % MOD);
    }
}

int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        scanf("%s", str[i] + 1);
    }
    for (int j = 1; j <= m; j++) {
        vector<char> now;
        now.clear();
        for (int i = 1; i <= n; i++) {
            now.push_back(str[i][j]);
        }
        sort(now.begin(), now.end());
        for (int i = 1; i < n; i++) {
            if (now[i] != now[i-1]) {
                vec[j].push_back(now[i-1]);
            }
        }
        if (now[n-1] != now[n-2]) {
            vec[j].push_back(now[n-1]);
        }
        sort(vec[j].begin(), vec[j].end());
    }

    mp.clear();
    for (int i = 1; i <= n; i++) {
        ULL now = 0;
        int k = strlen(str[i] + 1);
        for (int j = 1; j <= k; j++) {
            now = (now * BASE + (str[i][j] - 'A')) % MOD;
        }
        mp[now] = true;
    }

    flag = false;
    dfs(1, 0);

    ans[m + 1] = '\0';
    if (flag) {
        printf("%s\n", ans + 1);
    } else {
        printf("-\n");
    }
    return 0;
}

/*
4 4
COKE
TARN
SHOW
AABC
 */