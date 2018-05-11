var ans bool

func isInterleave(s1 string, s2 string, s3 string) bool {
    ans = false
    x, y, z := len(s1), len(s2), len(s3)
    if x + y != z {
        return false
    }
    dfs(0, 0, 0, s1, s2, s3, x, y, z)
    return ans
}

func dfs(i int, j int, k int, s1 string, s2 string, s3 string, x int, y int, z int) {
    if ans || (z == k && i == x && j == y) {
        ans = true
        return 
    }
    if k < z && i < x && s1[i] == s3[k] {
        dfs(i + 1, j, k + 1, s1, s2, s3, x, y, z)
    }
    if k < z && j < y && s2[j] == s3[k] {
        dfs(i, j + 1, k + 1, s1, s2, s3, x, y, z)
    }
} 