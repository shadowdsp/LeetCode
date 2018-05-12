func generateMatrix(n int) [][]int {
    dx, dy, x, y := []int{0, 1, 0, -1}, []int{1, 0, -1, 0}, 0, 0
    ans := make([][]int, n)
    for i := 0; i < n; i++ {
        ans[i] = make([]int, n)
    }
    cnt := 1
    dir := 0
    for {
        ans[x][y] = cnt
        if cnt >= n * n {
            break
        }
        nx, ny := x + dx[dir], y + dy[dir]
        if 0 <= nx && nx < n && 0 <= ny && ny < n && ans[nx][ny] == 0 {
            x, y = nx, ny
            cnt++
        } else {
            dir = (dir + 1) % 4
        }
    }
    return ans
}