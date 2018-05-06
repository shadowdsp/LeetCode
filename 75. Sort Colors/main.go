func sortColors(nums []int)  {
    for i, left, right := 0, 0, len(nums) - 1; i <= right && left <= right; {
        if nums[i] == 0 {
            swap(&nums[i], &nums[left])
            left++
            i++
        } else if nums[i] == 1 {
            i++
        } else {
            swap(&nums[i], &nums[right])
            right--
        }
    }
}

func swap(a *int, b *int) {
    tmp := *a
    *a = *b
    *b = tmp
}