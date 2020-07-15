func numTrees(n int) int {
    table := make([]int, n+2)
    table[0], table[1], table[2] = 1, 1, 2
    for i := 3; i <= n; i++ {
        for j := 1; j <= i; j++ {
			table[i] += table[j-1] * table[i-j]
		}
	}
	return table[n];
}
