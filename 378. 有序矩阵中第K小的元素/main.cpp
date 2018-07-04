class Solution {
public:
    struct Node {
        int x, id, c;
        bool operator < (const Node &rhs) const {
            return x > rhs.x;
        }
    };
    
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        if (n <= 0) return 0;
        int m = matrix[0].size();
        if (m <= 0) return 0;
        priority_queue<Node> que;
        int cnt[n];
        memset(cnt, 0, sizeof cnt);
        for (int i = 0; i < n; i++) 
            que.push((Node){matrix[i][0], i, 0});
        while (k > 0) {
            Node now = que.top(); que.pop();
            if ((--k) == 0) return now.x;
            if (now.c + 1 < m) que.push((Node){matrix[now.id][now.c+1], now.id, now.c+1});
        }
        return 0;
    }
};