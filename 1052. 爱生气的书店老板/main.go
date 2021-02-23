func maxSatisfied(customers []int, grumpy []int, X int) int {
    ret := 0
    for i := 0; i < len(customers); i++ {
        if grumpy[i] == 0 {
            ret += customers[i]
        }
    }
    r := 0
    sum := ret
    for r < len(customers) && r < X {
        sum += grumpy[r] * customers[r]
        if sum > ret {
            ret = sum
        }
        r++
    }
    for r < len(customers) {
        sum = sum + grumpy[r] * customers[r] - grumpy[r-X] * customers[r-X]
        if sum > ret {
            ret = sum
        }
        r++
    }
    return ret
}