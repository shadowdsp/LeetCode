func maxEnvelopes(envelopes [][]int) int {
	n := len(envelopes)
	if n <= 0 {
		return 0
	}
	sort.Slice(envelopes, func(i, j int) bool {
		a, b := envelopes[i], envelopes[j]
		return a[0] < b[0] || a[0] == b[0] && a[1] > b[1]
	})

	seq := []int{}
	for _, e := range envelopes {
		num := e[1]
		if index := sort.SearchInts(seq, num); index < len(seq) {
			seq[index] = num
		} else {
			seq = append(seq, num)
		}
	}
	return len(seq)
}