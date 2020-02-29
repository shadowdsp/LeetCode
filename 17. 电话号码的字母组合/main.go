func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	dm := make(map[byte]string)
	dm['2'] = "abc"
	dm['3'] = "def"
	dm['4'] = "ghi"
	dm['5'] = "jkl"
	dm['6'] = "mno"
	dm['7'] = "pqrs"
	dm['8'] = "tuv"
	dm['9'] = "wxyz"
	res := make([]string, 0)
	solve(digits, dm, 0, "", &res)
	return res
}

func solve(digits string, dm map[byte]string, index int, current string, res *[]string) {
	if index == len(digits) {
		*res = append(*res, current)
		return
	}
	c := digits[index]
	for i := 0; i < len(dm[c]); i++ {
		newStr := current + string(dm[c][i])
		solve(digits, dm, index+1, newStr, res)
	}
}