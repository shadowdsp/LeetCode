var ans bool
var dx = []int{1, -1, 0, 0}
var dy = []int{0, 0, 1, -1}

func exist(board [][]byte, word string) bool {
    ans = false
    n := len(board)
    if n <= 0 {
        return false
    }
    m := len(board[0])
    if m <= 0 {
        return false
    }
    len := len(word)
    if len <= 0 {
        return true
    }
    vis := make([][]bool, n)
    for i := 0; i < n; i++ {
        vis[i] = make([]bool, m)
    }
    for i := 0; i < n; i++ {
        for j := 0; j < m; j++ {
            dfs(board, i, j, n, m, 0, word, vis)
        }
    }
    return ans
}

func dfs(board [][]byte, x int, y int, n int, m int, id int, word string, vis [][]bool) {
    if vis[x][y] || board[x][y] != []byte(word)[id] {
        return 
    }
    if ans || id == len(word) - 1 {
        ans = true
        return 
    }
    vis[x][y] = true
    for k := 0; k < 4; k++ {
        nx, ny := x + dx[k], y + dy[k]
        if 0 <= nx && nx < n && 0 <= ny && ny < m {
            dfs(board, nx, ny, n, m, id + 1, word, vis)
        }
    }
    vis[x][y] = false
}
