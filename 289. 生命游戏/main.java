class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        if (n <= 0) return ;
        int m = board[0].length;
        if (m <= 0) return ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                int lx = Math.max(0, i-1), ly = Math.max(0, j-1), rx = Math.min(n-1, i+1), ry = Math.min(m-1, j+1);
                for (int x = lx; x <= rx; x++) {
                    for (int y = ly; y <= ry; y++) {
                        if (x == i && y == j) continue;
                        if (board[x][y] == 1 || board[x][y] == 2) cnt++;
                    }
                }
                if (board[i][j] == 0) board[i][j] = cnt == 3 ? 3 : 0;
                else if (cnt < 2 || cnt > 3) board[i][j] = 2;
            }
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                board[i][j] %= 2;
    }
}