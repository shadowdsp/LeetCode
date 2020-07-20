// hash
func twoSum(numbers []int, target int) []int {
    numsMap := make(map[int]int, 0)
    for index, number := range numbers {
        numsMap[number] = index + 1
    }
    for index, number := range numbers {
        temp := numsMap[target - number]
        if temp > 0 && temp != index + 1 {
            return []int{index + 1, temp}
        }
    }
    return []int{0, 0}
}

// two pointers
func twoSum(numbers []int, target int) []int {
    l, r := 0, len(numbers) - 1
    for ; l < r; {
        if numbers[l] + numbers[r] == target {
            return []int{l+1, r+1}
        } else if numbers[l] + numbers[r] < target {
            l++
        } else {
            r--
        }
    }
    return []int{0, 0}
}