func removeDuplicates(nums []int) int {
    n := len(nums)
    l, r := 0, 0
    for r < n {
        count := 0
        num := nums[r]
        for r < n && num == nums[r] {
            if count < 2 {
                nums[l] = nums[r]
                l++
            }
            count++
            r++
        }
    }
    return l
}