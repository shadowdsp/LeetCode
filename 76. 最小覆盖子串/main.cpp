class Solution {
public:
    string minWindow(string s, string t) {
        int n = s.length();
        int m = t.length();
        int hash[256];
        memset(hash, 0, sizeof hash);
        int cnt[256];
        memset(cnt, 0, sizeof cnt);
        for (int i = 0; i < m; i++) {
            hash[t[i]]++;
        }
        int now = 0, l = 0, r = 0, ansl = -1, ansr = -1, milen = 1 << 30;

        while (r < n) {
            int c = s[r];
            cnt[c]++;
            if (cnt[c] <= hash[c]) {
                now++;
            }

            while (now >= m && l <= r && l < n) {
                if (now >= m && r - l  + 1 < milen) {
                    milen = r - l + 1;
                    ansl = l, ansr = r;
                }
                int c = s[l++];
                cnt[c]--;
                if (cnt[c] < hash[c]) {
                    now--;
                }
            }
            r++;
        }

        while (now >= m && l <= r && l < n) {
            if (r - l + 1 < milen) {
                milen = r - l + 1;
                ansl = l, ansr = r;
            }
            int c = s[l++];
            cnt[c]--;
            if (cnt[s[l]] < hash[s[l]]) {
                now--;
            }
        }
        if (ansl == -1) {
            return "";
        } else {
            string ans = "";
            for (int i = ansl; i <= ansr; i++) {
                ans += s[i];
            }
            return ans;
        }
    }
};