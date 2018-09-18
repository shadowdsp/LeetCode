#include <bits/stdc++.h>

using namespace std;
typedef long long LL;
const int N = 1011;

struct P {
    double x, y, r;
    bool vis;
} p[N];

struct D {
    int a, b;
    double dis;
    double rea;
};

vector<D> vec;

bool cmp(const D &x, const D &y) {
    return x.rea < y.rea;
}

double sqr(double x) {
    return x * x;
}

double cal(P a, P b) {
    return sqrt(sqr(a.x - b.x) + sqr(a.y - b.y));
}

double ccal(P a, P b) {
    if (!a.vis && !b.vis) {
        return sqrt(sqr(a.x - b.x) + sqr(a.y - b.y)) / 2;
    } else {
        return sqrt(sqr(a.x - b.x) + sqr(a.y - b.y)) - a.r - b.r;
    }
}

void solve(int n) {
    while (true) {
        bool ok = true;
        for (int i = 1; i <= n; i++) {
            if (!p[i].vis) {
                ok = false;
            }
        }
        if (ok) break;

        vec.clear();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (p[i].vis && p[j].vis) continue;
                vec.push_back((D){i, j, cal(p[i], p[j]), ccal(p[i], p[j])});
            }
        }

        sort(vec.begin(), vec.end(), cmp);
        int u = vec[0].a, v = vec[0].b;
        if (!p[u].vis && !p[v].vis) {
            p[u].r = p[v].r = vec[0].dis / 2;
        } else {
            if (!p[u].vis) {
                p[u].r = vec[0].dis - p[v].r;
            } else {
                p[v].r = vec[0].dis - p[u].r;
            }
        }
        p[u].vis = p[v].vis = true;

    }
}

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> p[i].x >> p[i].y;
        p[i].r = 0;
        p[i].vis = false;
    }
    solve(n);
    for (int i = 1; i <= n; i++) {
        printf("%.3f%c", p[i].r, i == n ? '\n' : ' ');
    }
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