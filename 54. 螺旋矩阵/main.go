func spiralOrder(matrix [][]int) []int {
    ans := make([]int, 0)
    n := len(matrix)
    if n <= 0 {
        return ans
    }
    m := len(matrix[0])
    if m <= 0 {
        return ans
    }
    var dep int
    if m < n {
        dep = m
    } else {
        dep = n
    }
    dep = (dep - 1) / 2
    for d := 0; d <= dep; d++ {
        for i := d; i < m - d; i++ {
            ans = append(ans, matrix[d][i])
        }
        for i := d + 1; i < n - d; i++ {
            ans = append(ans, matrix[i][m-d-1])
        }
        for i := m - d - 2; i >= d && n - d - 1 != d; i-- {
            ans = append(ans, matrix[n-d-1][i])
        }
        for i := n - d - 2; i > d && m - d - 1 != d; i-- {
            ans = append(ans, matrix[i][d])
        }
    }
    return ans
}