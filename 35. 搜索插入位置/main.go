func searchInsert(nums []int, target int) int {
    l, r := 0, len(nums) - 1;
    ans := r + 1
    for l <= r {
        m := (l + r) / 2
        if nums[m] >= target {
            ans = m
            r = m - 1
        } else {
            l = m + 1
        }
    }
    return ans
}