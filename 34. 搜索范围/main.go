func searchRange(nums []int, target int) []int {
    n := len(nums)
    res := make([]int, 2)
    res[0] = -1
    res[1] = -1
    if n <= 0 {
        return res
    }
    l := lowerbound(nums, target, 0, n - 1)
    r := upperbound(nums, target, 0, n - 1)
    if nums[l] == target {
        res[0] = l
    }
    if nums[r] == target {
        res[1] = r
	}
	fmt.Println(l, r)
    return res
}

func upperbound(nums []int, target int, l int, r int) int {
    ans := l
    for l <= r {
        m := (l + r) / 2
        if nums[m] <= target {
            l = m + 1
            ans = m
        } else {
            r = m - 1
        }
    }
    return ans
}

func lowerbound(nums []int, target int, l int, r int) int {
    ans := r
    for l <= r {
        m := (l + r) / 2
        if nums[m] >= target {
            r = m - 1
            ans = m
        } else {
            l = m + 1
        }
    }
    return ans
}