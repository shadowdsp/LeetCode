func removeElement(nums []int, val int) int {
    n := len(nums)    
    l := 0
    for r := 0; r < n; r++ {
        if nums[r] != val {
            nums[l] = nums[r]
            l++
        }
    }
    return l
}