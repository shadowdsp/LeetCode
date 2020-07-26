class Solution {
public:
    int getNodeId(int row, int column, int m) {
        return row * m + column;
    }

    int dfs(int u, vector<int> edge[], int node_depth[], int depth) {
        int ret = 1;
        for (int i = 0; i < edge[u].size(); i++) {
            int v = edge[u][i];
            if (node_depth[v] != 0) {
                ret = max(ret, node_depth[v] + 1);
                continue;
            }
            ret = max(ret, dfs(v, edge, node_depth, depth + 1) + 1);
        }
        node_depth[u] = ret;
        return ret;
    }

    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if (n <= 0) {
            return 0;
        }
        int m = matrix[0].size();
        if (m <= 0) {
            return 0;
        }
        int node_nums = n * m;
        vector<int> edge[node_nums];
        int indegree[node_nums];
        int node_depth[node_nums];
        for (int i = 0; i < node_nums; i++) {
            indegree[i] = 0;
            node_depth[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u = getNodeId(i, j, m);
                if (i + 1 < n && matrix[i][j] < matrix[i+1][j]) {
                    int v = getNodeId(i + 1, j, m);
                    edge[u].push_back(v);
                    indegree[v]++;
                }
                if (j + 1 < m && matrix[i][j] < matrix[i][j+1]) {
                    int v = getNodeId(i, j + 1, m);
                    edge[u].push_back(v);
                    indegree[v]++;
                }
                if (i > 0 && matrix[i][j] < matrix[i-1][j]) {
                    int v = getNodeId(i - 1, j, m);
                    edge[u].push_back(v);
                    indegree[v]++;
                }
                if (j > 0 && matrix[i][j] < matrix[i][j-1]) {
                    int v = getNodeId(i, j - 1, m);
                    edge[u].push_back(v);
                    indegree[v]++;
                }
            }
        }
        int ret = 0;
        for (int u = 0; u < node_nums; u++) {
            if (indegree[u] > 0) {
                continue;
            }
            ret = max(ret, dfs(u, edge, node_depth, 1));
        }
        return ret;
    }
};