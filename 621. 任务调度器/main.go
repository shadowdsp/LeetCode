package main

import (
	"sort"
)

func leastInterval(tasks []byte, n int) int {
	cnt := make([]int, 26)
	for i := 0; i < len(tasks); i++ {
		c := tasks[i] - 'A'
		cnt[c]++
	}
	sort.Ints(cnt)
	sum := (cnt[25] - 1) * n
	for i := 24; i >= 0; i-- {
		x := cnt[25] - 1
		if cnt[i] < x {
			x = cnt[i]
		}
		sum -= x
	}
	if sum < 0 {
		return len(tasks)
	} else {
		return len(tasks) + sum
	}
}
