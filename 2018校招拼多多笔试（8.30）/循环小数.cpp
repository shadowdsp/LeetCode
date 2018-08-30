#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;

unordered_map<int, int> mp;

pii solve(int a, int b) {
    mp.clear();
    for (int index = 0; ; index++) {
        a = a % b;
        if (a == 0) {
            return {index, 0};
        }
        if (mp.find(a) != mp.end()) {
            return {mp[a], index - mp[a]};
        } else {
            mp[a] = index;
        }
        a *= 10;
    }
}

int main() {
    int a, b;
    cin >> a >> b;
    pii ans = solve(a, b);
    cout << ans.first << " " << ans.second << endl;
    return 0;
}