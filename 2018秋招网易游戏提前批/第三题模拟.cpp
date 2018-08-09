#include <cstdio>
#include <string>
#include <map>
#include <iostream>
using namespace std;
const int N = 111;
typedef pair<string, int> psi;

int L[N], R[N], rankScore[N];
int A, B;
int killlScore[N];
int tid[N];
string killl[N], vic[N];
int ans[N];

int killlCnt[N];
string name[N];
map<string, int> mp;
psi fen[N];

int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int q, m, n;
        int tol = 0;
        memset(ans, 0, sizeof ans);
        mp.clear();
        cin >> q >> n >> m;
        for (int i = 1; i <= n; i++) {
            scanf("%d%d%d", &L[i], &R[i], &rankScore[i]);
        }
        for (int i = 0; i <= m; i++) {
            scanf("%d", &killlScore[i]);
        }
        scanf("%d%d", &A, &B);
        memset(killlCnt, 0, sizeof killlCnt);
        for (int i = 1; i < q; i++) {
            cin >> tid[i] >> killl[i] >> vic[i];
            if (!mp[killl[i]]) {
                mp[killl[i]] = ++tol;
                name[tol] = killl[i];
            }
            if (!mp[vic[i]]) {
                mp[vic[i]] = ++tol;
                name[tol] = vic[i];
            }
            int a = mp[killl[i]], b = mp[vic[i]];

            if (a == b) {
                ans[b] += A * tid[i] + B;
                int id = q - i + 1;
                for (int j = 1; j <= n; j++) {
                    if (L[j] <= id && id <= R[j]) {
                        ans[b] += rankScore[j];
                        break;
                    }
                }
                continue;
            }

            killlCnt[a]++;
            ans[a] += killlScore[min(m, killlCnt[b])];

            ans[b] += A * tid[i] + B;
            if (i == q - 1) {
                int id = 1;
                ans[a] += A * tid[i] + B;
                for (int j = 1; j <= n; j++) {
                    if (L[j] <= id && id <= R[j]) {
                        ans[a] += rankScore[j];
                        break;
                    }
                }
            }

            int id = q - i + 1;
            for (int j = 1; j <= n; j++) {
                if (L[j] <= id && id <= R[j]) {
                    ans[b] += rankScore[j];
                    break;
                }
            }
        }

        for (int i = 1; i <= q; i++) {
            fen[i] = {name[i], ans[i]};
        }
        sort(fen + 1, fen + 1 + q);
        for (int i = 1; i <= q; i++) {
            cout << fen[i].first << " " << fen[i].second << endl;
        }
    }
    return 0;
}

/*
2

10 6 3
1 1 300
2 2 250
3 3 200
4 5 100
6 8 50
9 10 10
10 50 100 150
5 1
0 Apple Ball
1 Cat Dog
2 Elephane Fish
5 Gorilla Hat
8 Igloo Juice
10 Cat Cat
10 Elephane Igloo
15 Gorilla Elephane
20 Apple Gorilla

10 4 4
6 10 10
4 5 20
2 3 25
1 1 30
1 5 10 15 30
2 50
5 Apple apple
15 appleApple Apple
18 Gorilla Fish
20 Gorilla Hat
20 Igloo Juice
30 Gorilla appleApple
40 Elephane Igloo
55 Gorilla Elephane
60 Appleapple Gorilla

Apple 511
Ball 11
Cat 161
Dog 16
Elephane 336
Fish 61
Gorilla 461
Hat 76
Igloo 161
Juice 91
Apple 91
Appleapple 230
Elephane 190
Fish 96
Gorilla 207
Hat 100
Igloo 151
Juice 100
apple 70
appleApple 135

 */