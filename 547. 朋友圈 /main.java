class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n <= 0) return 0;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans++;
                dfs(i, vis, M, n);
            }
        }
        return ans;
    }
    
    private void dfs(int u, boolean[] vis, int[][] M, int n) {
        vis[u] = true;
        for (int i = 0; i < n; i++) {
            if (M[u][i] == 1 && !vis[i]) {
                dfs(i, vis, M, n);
            }
        }
    }
}