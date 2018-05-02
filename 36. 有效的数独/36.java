class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        if (n <= 0) return false;
        int m = board[0].length;
        if (m <= 0) return false;
        for (int i = 0; i < n; i++) {
            int st = 0;
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '0';
                    if (((1 << c) & st) != 0) {
                        return false;
                    }
                    st |= (1 << c);
                }
            }
        }
        
        for (int j = 0; j < m; j++) {
            int st = 0;
            for (int i = 0; i < m; i++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '0';
                    if (((1 << c) & st) != 0) {
                        return false;
                    }
                    st |= (1 << c);
                }
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int st = 0;
                for (int x = i * 3; x < (i + 1) * 3; x++) {
                    for (int y = j * 3; y < (j + 1) * 3; y++) {
                        if (board[x][y] != '.') {
                            int c = board[x][y] - '0';
                            if (((1 << c) & st) != 0) {
                                return false;
                            }
                            st |= (1 << c);
                        }
                    }
                }
            }
        }
        return true;
    }
}