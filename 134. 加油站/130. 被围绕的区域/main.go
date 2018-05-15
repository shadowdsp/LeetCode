var dx, dy = []int{1, -1, 0, 0}, []int{0, 0, 1, -1}
func solve(board [][]byte)  {
    n := len(board)
    if n <= 0 {
        return 
    }
    m := len(board[0])
    if m <= 0 {
        return 
    }
    vis := make([][]bool, n)
    for i := 0; i < n; i++ {
        vis[i] = make([]bool, m)
    }
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) && string(board[i][j]) == "O" {
                dfs(i, j, vis, board, n, m)
            }
        }
    }
    
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            if !vis[i][j] {
                board[i][j] = []byte("X")[0]
            }
        }
    }
}

func dfs(x int, y int, vis [][]bool, board [][]byte, n int, m int) {
    if vis[x][y] {
        return 
    }
    vis[x][y] = true
    for i := 0; i < 4; i++ {
        nx, ny := x + dx[i], y + dy[i]
        if 0 <= nx && nx < n && 0 <= ny && ny < m && string(board[nx][ny]) == "O" {
            dfs(nx, ny, vis, board, n, m)
        }
    }
}