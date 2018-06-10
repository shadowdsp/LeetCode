class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n <= 0) return 0;
        int m = grid[0].length;
        if (m <= 0) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }
    
    void dfs(int x, int y, char[][] grid, int n, int m) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == '1') {
                dfs(nx, ny, grid, n, m);
            }
        }
    }
}