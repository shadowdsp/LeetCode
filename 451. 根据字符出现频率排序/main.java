class Solution {
public:
    string frequencySort(string s) {
        pair<int, char> hash[128];
        for (int i = 0; i < 128; i++) hash[i].first = 0, hash[i].second = i;
        int n = s.size();
        for (int i = 0; i < n; i++) hash[s[i]].first++;
        sort(hash, hash + 128);
        string ans = "";
        for (int i = 127; i >= 0; i--) {
            while (hash[i].first > 0) {
                ans += (char)hash[i].second;
                hash[i].first--;
            }
        }
        return ans;
    }
};