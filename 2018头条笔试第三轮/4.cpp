// utf8
// 模拟
#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
const int N = 1e5 + 11;
int nums[N];
int n;
int bit[10];

void reduce(int num) {
    memset(bit, 0, sizeof bit);
    int cnt = 0;
//    printf("%d\n", num);
    for (int i = 0; i < 8; i++) {
        bit[8-i-1] = (num & (1 << i)) > 0 ? 1 : 0;
//        printf("%d", bit[8-i-1]);
    }
//    cout << endl;
}

bool check() {
    int total = n / 4;
    int rem = n % 4;

//    printf("%d - %d\n", total, rem);

    for (int part = 0; part < total; part++) {
        reduce(nums[part * 4 + 1]);
        for (int i = 0; i < 4; i++) {
            if (bit[i] == 0) return false;
        }
        if (bit[4] == 1) return false;
        for (int i = 2; i <= 4; i++) {
            reduce(nums[part * 4 + i]);
            if (bit[0] == 0) return false;
            if (bit[1] == 1) return false;
        }
    }
    if (rem <= 0) return true;
    reduce(nums[total * 4 + 1]);
    if (rem == 1) {
        if (bit[0] == 1) return false;
    } else {
        for (int i = 0; i < rem; i++) {
            if (bit[i] == 0) return false;
        }
        if (bit[rem] == 1) return false;
        for (int i = 2; i <= rem; i++) {
            reduce(nums[total * 4 + i]);
            if (bit[0] == 0) return false;
            if (bit[1] == 1) return false;
        }
    }
    return true;
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> nums[i];
    }
    cout << (check() ? 1 : 0) << endl;
    return 0;
}

/*
255255255255
1001101
 10001
*/