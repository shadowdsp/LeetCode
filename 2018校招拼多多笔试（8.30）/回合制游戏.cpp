#include <bits/stdc++.h>
using namespace std;

int main() {
    int hp;
    int a, b;
    cin >> hp >> a >> b;
    int ans = 0;
    if (b <= a * 2) {
        ans = (hp + a - 1) / a;
    } else {
        ans += hp / b * 2;
        hp %= b;
        if (hp > 0) {
            if (hp <= a) ans++;
            else ans += 2;
        }
    }
    printf("%d\n", ans);
    return 0;
}