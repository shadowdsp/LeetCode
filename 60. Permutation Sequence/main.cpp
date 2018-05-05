class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> vec;
        for (int i = 1; i <= n; i++) {
            vec.push_back(i);
        }
        do {
            k--;
        } while (k && next_permutation(vec.begin(), vec.end()));
        string s = "";
        for (int i = 0; i < n; i++) {
            s += to_string(vec[i]);
        }
        return s;
    }
};