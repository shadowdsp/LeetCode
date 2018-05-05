func canJump(nums []int) bool {
    n := len(nums)
    far := 0
    for i := 0; i <= far && i < n; i++ {
        if far < i + nums[i] {
            far = i + nums[i]
        }
    }
    return far >= n - 1
}