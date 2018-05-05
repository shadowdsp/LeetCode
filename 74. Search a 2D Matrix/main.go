func searchMatrix(matrix [][]int, target int) bool {
    n := len(matrix)
    if n <= 0 {
        return false
    }
    m := len(matrix[0])
    if m <= 0 {
        return false
    }
    for i, j := 0, m - 1; i < n && j >= 0; {
        num := matrix[i][j]
        if num == target {
            return true
        } else if num < target {
            i++
        } else {
            j--
        }
    }
    return false
}