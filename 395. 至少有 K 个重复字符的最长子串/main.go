func longestSubstring(s string, k int) int {
	if s == "" {
		return 0
	}
	cnt := [26]int{}
	for _, c := range s {
		cnt[c-'a']++
	}
	var ch byte
	for i, v := range cnt {
		if 0 < v && v < k {
			ch = 'a' + byte(i)
			break
		}
	}
	if ch == 0 {
		return len(s)
	}
	ret := 0
	for _, sub := range strings.Split(s, string(ch)) {
		cur := longestSubstring(sub, k)
		if cur > ret {
			ret = cur
		}
	}
	return ret
}