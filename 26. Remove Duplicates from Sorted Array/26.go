func removeDuplicates(nums []int) int {
    n := len(nums)
    if n <= 1 {
        return n
    }
    cnt := 1
    for i := 1; i < n; i++ {
        if nums[i] != nums[cnt-1] {
            nums[cnt] = nums[i]
            cnt++
        }
    }
    return cnt
}