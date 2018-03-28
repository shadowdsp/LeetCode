/*
牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。

输入描述:
输入包括两行
第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。


输出描述:
输出一个正整数, 表示牛牛一共有多少种零食放法。

输入例子1:
3 10
1 2 4

输出例子1:
8

例子说明1:
三种零食总体积小于10,于是每种零食有放入和不放入两种情况，一共有2*2*2 = 8种情况。
*/

#include <bits/stdc++.h>
using namespace std;
const int N = 16;
long v[N*2], cb1[1<<N|1], cb2[1<<N|1], w;
int n;

void dfs(int l, int r, long c[], int &cnt) {
    int d = r - l + 1;
    for (int i = 0; i < (1 << d); i++) {
        long val = 0;
        for (int j = 0; j < d; j++) {
            if (i & (1 << j)) {
                val += v[l+j];
                if (val > w) break;
            }
        }
        if (val <= w) c[cnt++] = val;
    }
}

int main() {
    // 超大背包问题，变成折半枚举出一半物品的情况，然后二分查找
    scanf("%d%lld", &n, &w);
    for (int i = 0; i < n; i++) scanf("%lld", &v[i]);
    int cnt1 = 0, cnt2 = 0;
    // 分为前后两部份
    dfs(0, (n - 1) / 2, cb1, cnt1);
    dfs((n - n / 2), n - 1, cb2, cnt2);
    sort(cb1, cb1 + cnt1);
    long ans = 0;
    for (int i = 0; i < cnt2; i++) // 如果是下标的话需要-1，因为找的是个数，个数从0开始，所以不用-1
        ans += upper_bound(cb1, cb1 + cnt1, w - cb2[i]) - cb1;
    printf("%lld\n", ans);
    return 0;
}
