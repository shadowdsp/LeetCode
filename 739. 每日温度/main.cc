class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        stack<int> st;
        vector<int> ret(T.size());
        for (int i = 0; i < T.size(); i++) {
            while (!st.empty() && T[st.top()] < T[i]) {
                ret[st.top()] = i - st.top();
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()) {
            ret[st.top()] = 0;
            st.pop();
        }
        return ret;
    }
};