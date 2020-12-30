class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        int n = stones.size();
        if (n <= 0) {
            return 0;
        } else if (n <= 1) {
            return stones[0];
        }
        priority_queue<int> que;
        for (int i = 0; i < stones.size(); i++) {
            que.push(stones[i]);
        }
        while (que.size() > 1) {
            int a = que.top(); que.pop();
            int b = que.top(); que.pop();
            if (a != b) {
                que.push(a - b);
            }
        }
        return que.empty() ? 0 : que.top();
    }
};