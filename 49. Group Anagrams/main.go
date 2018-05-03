func groupAnagrams(strs []string) [][]string {
    mp := make(map[string]int)
    n := len(strs)
    var ans [][]string
    for i := 0; i < n; i++ {
        s := Sortc(strs[i])
        if v, ok := mp[s]; ok {
            ans[v] = append(ans[v], strs[i])
        } else {
            mp[s] = len(ans)
            ss := []string {strs[i]}
            ans = append(ans, ss)
        }
    }
    return ans
}

func StringToRuneSlice(s string) []rune {
    var r []rune
    for _, val := range s {
        r = append(r, val)
    }
    return r
}

func Sortc(s string) string {
    r := StringToRuneSlice(s)
    sort.Slice(r, func(i, j int) bool {
        return r[i] < r[j]
    })
    return string(r)
}