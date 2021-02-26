// 状态压缩
func findNumOfValidWords(words []string, puzzles []string) []int {
	hash := make(map[int]int)
	for _, word := range words {
		num := 0
		for _, c := range word {
			num |= 1 << (c - 'a')
		}
		hash[num]++
	}
	ret := []int{}
	for _, p := range puzzles {
		sum := 0
		cnt := 1 << 6
		for i := 1; i <= cnt; i++ {
			num := 1 << (p[0] - 'a')
			for j := 0; j < 6; j++ {
				if (i>>j)&1 == 1 {
					num |= 1 << (p[1+j] - 'a')
				}
			}
			sum += hash[num]
		}
		ret = append(ret, sum)
	}
	return ret
}