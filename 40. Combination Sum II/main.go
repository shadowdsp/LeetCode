var ans [][]int
var mp map[string]bool
var vis []bool

func combinationSum2(candidates []int, target int) [][]int {
	ans = make([][]int, 0)
	vis = make([]bool, len(candidates))
	mp = make(map[string]bool)
    dfs(candidates, target, make([]int, 0))
    return ans
}

func dfs(candidates []int, sum int, num []int) {
    if (sum == 0) {
		tmp := make([]int, len(num))
		copy(tmp, num)
        sort.Ints(tmp)
        s := ""
        n := len(tmp)
        for i := 0; i < n; i++ {
            s += string(tmp[i])
        }
        if _, ok := mp[s]; !ok {
            ans = append(ans, tmp)
            mp[s] = true
        }
    } else {
        n := len(candidates)
        for i := 0; i < n; i++ {
            if !vis[i] {
                if sum - candidates[i] >= 0 {
                    vis[i] = true
                    num = append(num, candidates[i])
                    dfs(candidates, sum - candidates[i], num)
					num = num[:len(num) - 1]
                    vis[i] = false
                }
            }
        }
    }
}