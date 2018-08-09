#include <cstdio>
#include <string>
#include <map>
#include <iostream>
using namespace std;

const int N = 20011;
int tree[N*10][10], flag[N*10];
string str[N];
string city[N];
//map<int, string> map;
int n, m, cnt;

void insert(string s, int index) {
    int len = s.size();
    int now = 0;
    for (int i = 0; i < len; i++) {
        if (!('0' <= s[i] && s[i] <= '9')) break;
        int c = s[i] - '0';
        if (tree[now][c] == -1) {
            tree[now][c] = ++cnt;
        }
        now = tree[now][c];
    }
//    cout << now << " : " << index << endl;
    flag[now] = index;
}

int find(string s) {
    int len = s.size();
    int now = 0;
    for (int i = 0; i < len; i++) {
        int c = s[i] - '0';
        if (now == -1) return 0;
        if (flag[now] > 0) return flag[now];
        now = tree[now][c];
    }
    return flag[now];
}

int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        memset(tree, -1, sizeof tree);
        memset(flag, 0, sizeof flag);
        city[0] = "unknown";
        cnt = 0;
        scanf("%d", &n);
        for (int i = 1; i <= n; i++) {
            cin >> str[i];
            insert(str[i], i);
            cin >> city[i];
        }
        scanf("%d", &m);
        for (int i = 1; i <= m; i++) {
            string s;
            cin >> s;
            int ans = find(s);
            cout << city[ans] << endl;
        }
    }
    return 0;
}

/*
2
3
1357xxxxxxx GuangZhou01
13680xxxxxx GuangZhou01
13799xxxxxx HangZhou02
3
13579246810
13680246810
13799999999
5
3333xxxxxxx nowhere
3334xxxxxxx somewhere
33355555xxx nobody
33355566666 somebody
33366666xxx NULL
10
33333333333
33344444444
33444444444
44444443334
33355566666
33355533355
33366666633
66663336633
33355533341
33338888888
 */