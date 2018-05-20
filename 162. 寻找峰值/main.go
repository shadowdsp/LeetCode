func findPeakElement(nums []int) int {
    n := len(nums)
    l, r := 0, n - 1
    for l < r {
        if l + 1 == r {
            if nums[l] < nums[r] {
                return r
            } else {
                return l
            }
        }
        mid := (l + r) / 2
        midd := (mid + r) / 2
        if mid + 1 == r {
            midd = (mid + r + 1) / 2
        }
        if midd == r {
            mx := l
            if nums[mx] < nums[mid] {
                mx = mid
            }
            if nums[mx] < nums[r] {
                mx = r
            }
            return mx
        }
        if nums[mid] < nums[midd] {
            l = mid
        } else {
            r = midd 
        }
        fmt.Println(l, r, mid, midd)
    }
    return l
}