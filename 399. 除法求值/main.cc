class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        // map + 邻接矩阵 + floyd
        map<string, int> mp;
        int cnt = 0;
        for (int i = 0; i < equations.size(); i++) {
            if (!mp[equations[i][0]]) {
                mp[equations[i][0]] = ++cnt;
            }
            if (!mp[equations[i][1]]) {
                mp[equations[i][1]] = ++cnt;
            }
        }
        double mat[cnt+1][cnt+1];
        for (int i = 1; i <= cnt; i++) {
            for (int j = 1; j <= cnt; j++) {
                mat[i][j] = -1.0;
            }
        }
        for (int i = 0; i < equations.size(); i++) {
            int x = mp[equations[i][0]], y = mp[equations[i][1]];
            mat[x][y] = values[i];
            mat[y][x] = 1.0 / values[i];
        }
        for (int k = 1; k <= cnt; k++) {
            for (int i = 1; i <= cnt; i++) {
                for (int j = 1; j <= cnt; j++) {
                    if (mat[i][k] == -1.0 || mat[k][j] == -1.0) {
                        continue;
                    }
                    mat[i][j] = mat[i][k] * mat[k][j];
                }
            }
        }
        vector<double> ret;
        for (int i = 0; i < queries.size(); i++) {
            string x = queries[i][0], y = queries[i][1];
            if (!mp[x] || !mp[y]) {
                ret.push_back(-1.0);
                continue;
            }
            ret.push_back(mat[mp[x]][mp[y]]);
        }
        return ret;
    }
};