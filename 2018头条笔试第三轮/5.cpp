// 抖音红人
// 强连通分量缩点建新图
#include <bits/stdc++.h>
using namespace std;
const int N = 5e4 + 11;
struct Edge {
    int v, nxt;
} edge[N*2], e[N*2];
int n, m, head[N], tot, h[N], t, dfn[N], low[N], belong[N], vis[N], num, tid, sz[N], deg[N];
stack<int> sta;
int dep[N];

void Add(int u, int v) { edge[tot] = (Edge) {v, head[u]}; head[u] = tot++; }
void add(int u, int v) { e[t] = (Edge) {v, h[u]}; h[u] = t++; }

void tarjan(int u) {
    sta.push(u);
    vis[u] = 1;
    dfn[u] = low[u] = ++tid;
    for(int i = head[u]; ~i; i = edge[i].nxt) {
        int v = edge[i].v;
        if(!dfn[v]) {
            tarjan(v);
            low[u] = min(low[u], low[v]);
        } else if(vis[v]) {
            low[u] = min(low[u], dfn[v]);
        }
    }
    if(low[u] == dfn[u]) {
        num++;
        int top = -1;
        while(top != u) {
            top = sta.top(); sta.pop();
            belong[top] = num;
            sz[num]++;
            vis[top] = 0;
        }
    }
}

void BuildGraph() {
    memset(head, -1, sizeof(head));
    memset(h, -1, sizeof(h));
    t = tot = 0;
    for(int i = 1; i <= m; i++) {
        int a, b;
        cin >> a >> b;
        Add(a, b);
    }
    for(int i = 1; i <= n; i++)
        if(!dfn[i]) tarjan(i);

    // 将环缩点重新建图
    for(int u = 1; u <= n; u++) {
        for(int i = head[u]; ~i; i = edge[i].nxt) {
            int v = edge[i].v;
            if(belong[u] != belong[v]) {
                add(belong[u], belong[v]);
                deg[belong[v]]++;
            }
        }
    }
}

void dfs(int u, int fa, int d) {
    dep[u] = sz[u] + d;
    for (int i = h[u]; ~i; i = e[i].nxt) {
        int v = e[i].v;
        if (v == fa) continue;
        dfs(v, u, dep[u]);
    }
}

int main() {
    cin >> n >> m;
    BuildGraph();
    int ans = 0;
    for (int i = 1; i <= num; i++) {
        if (deg[i] == 0) {
            dfs(i, -1, 0);
        }
    }
    if (num == 1) {
        ans = n;
    } else {
        for (int i = 1; i <= num; i++) {
            if (dep[i] == n) {
                ans += sz[i];
            }
        }
    }
    cout << ans << endl;
    return 0;
}