func setZeroes(matrix [][]int)  {
    n := len(matrix)
    if n <= 0 {
        return 
    }
    m := len(matrix[0])
    if m <= 0 {
        return 
    }
    col0 := 0
    for i := 0; i < n; i++ {
        if matrix[i][0] == 0 {
            col0 = 1
        }
        for j := 1; j < m; j++ {
            if matrix[i][j] == 0 {
                matrix[i][0], matrix[0][j] = 0, 0
            }
        }
    }
    
    for i := n - 1; i >= 0; i-- {
        for j := m - 1; j > 0; j-- {
            if matrix[i][0] == 0 || matrix[0][j] == 0 {
                matrix[i][j] = 0
            }
        }
        if col0 == 1 {
            matrix[i][0] = 0
        }
    }
}