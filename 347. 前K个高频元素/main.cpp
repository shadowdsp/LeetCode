class Solution {
public:
    typedef pair<int, int> pii;
    vector<int> topKFrequent(vector<int>& nums, int k) {
        priority_queue<pii> que;
        unordered_map<int, int> mp;
        int n = nums.size();
        for (int i = 0; i < n; i++) 
            mp[nums[i]]++;
        for (auto it = mp.begin(); it != mp.end(); it++) 
            que.push({it->second, it->first});
        vector<int> ans;
        for (int i = 0; i < k; i++) {
            ans.push_back(que.top().second);
            que.pop();
        }
        return ans;
    }
};