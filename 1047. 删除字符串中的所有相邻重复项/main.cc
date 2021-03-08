class Solution {
public:
    string removeDuplicates(string S) {
        string ret;
        for (char ch : S) {
            if (!ret.empty() && ret.back() == ch) {
                ret.pop_back();
            } else {
                ret.push_back(ch);
            }
        }
        return ret;
    }
};