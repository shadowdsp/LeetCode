class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        if (n <= 0) return board;
        int m = board[0].length;
        if (m <= 0) return board;
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        } else {
            dfs(r, c, board, n, m);
        }
        return board;
    }
    
    void dfs(int x, int y, char[][] board, int n, int m) {
        if (board[x][y] == 'E') {
            if (!check(x, y, board, n, m)) return ;
            board[x][y] = 'B';
            int[] dx = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
            int[] dy = new int[]{0, 0, 1, -1, 1, -1, -1, 1};
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    dfs(nx, ny, board, n, m);
                }
            }
        }
    }
    
    boolean check(int x, int y, char[][] board, int n, int m) {
        int left = Math.max(0, y - 1);
        int right = Math.min(y + 1, m - 1);
        int up = Math.min(x + 1, n - 1);
        int down = Math.max(0, x - 1);
        int cnt = 0;
        for (int i = down; i <= up; i++) {
            for (int j = left; j <= right; j++) {
                if (board[i][j] == 'M') {
                    cnt++;
                }
            }
        }
        if (cnt > 0) {
            board[x][y] = (char)('0' + cnt);
            return false;
        }
        return true;
    }
}