class Solution {
    typedef pair<int,int> pii;
    struct Node {
        int a, b;
        bool operator < (const Node &rhs) const {
            return (a + b) < (rhs.a + rhs.b);
        }
    };
    
public:
    vector<pair<int, int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<pii> ans;
        priority_queue<Node, vector<Node>, less<Node> > que;
        int sz = 0, n = nums1.size(), m = nums2.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node now = (Node) {nums1[i], nums2[j]};
                if (sz < k) {
                    sz++;
                    que.push(now);
                } else if (now < que.top()) {
                    que.pop();
                    que.push(now);
                }
            }
        }
        while (!que.empty()) {
            ans.push_back({que.top().a, que.top().b});
            que.pop();
        }
        return ans;
    }
};