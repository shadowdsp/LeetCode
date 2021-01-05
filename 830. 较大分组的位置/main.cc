class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {
        vector<vector<int>> ret;
        int l = 0, r = 0;
        while (r < s.length()) {
            while (s[l] == s[r] && r < s.length()) {
                r++;
            }
            if (r - l >= 3) {
                ret.push_back(vector<int>{l, r - 1});
            }
            l = r;
        }
        return ret;
    }
};