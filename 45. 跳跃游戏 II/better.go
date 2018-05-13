func jump(nums []int) int {
    n := len(nums)
    if n <= 1 {
        return 0
    }
    ans, r, ed := 0, nums[0], 0
    for i := 0; i < n; i = ed {
        ed = r
        ans++
        if ed >= n - 1 {
            break
        }
        for j := i + 1; j <= ed; j++ {
            if j + nums[j] > r {
                r = j + nums[j]
            }
        }
    }
    return ans
}