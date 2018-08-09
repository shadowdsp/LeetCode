#include <cstdio>
#include <iostream>
#include <cmath>
using namespace std;

double p[] = {0.03, 0.1, 0.2, 0.25, 0.3, 0.35, 0.45};
int num[] = {3000, 9000, 13000, 10000, 20000, 25000};

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int ans = 0;
        if (n <= 5000) {
            ;
        } else {
            n -= 5000;
            int cnt = 0;
            while (n > 0 && cnt < 6) {
                ans += (int)(p[cnt] * min(num[cnt], n) + 0.5);
                n -= num[cnt++];
            }
            if (n > 0) {
                ans += (int)(n * p[cnt] + 0.5);
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}

/*
 *
5
5000
15000
50000
8025
10001
 */