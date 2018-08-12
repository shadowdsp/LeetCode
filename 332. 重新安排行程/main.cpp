class Solution {
public:
    vector<string> findItinerary(vector<pair<string, string>> tickets) {
        if(tickets.size() == 0) return result;
        unordered_map<string, multiset<string>> hash;
        for(auto val: tickets) hash[val.first].insert(val.second);
        stack<string> st;
        st.push("JFK");
        while(!st.empty())
        {
            string s = st.top();
            if(hash.find(s) != hash.end() && hash[s].size() > 0) {
                st.push(*hash[s].begin());
                hash[s].erase(hash[s].begin());
            } else { 
                result.insert(result.begin(), s); st.pop();
            }
        }
        return result;
    }
private:
    vector<string> result;
};
