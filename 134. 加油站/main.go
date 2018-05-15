func canCompleteCircuit(gas []int, cost []int) int {
    n := len(gas)
    for i := 0; i < n; i++ {
        gas[i] -= cost[i]
    }
    ans := -1
    for i := 0; i < n; i++ {
        sum := 0
        for j := 0; j < n; j++ {
            sum += gas[(i + j) % n]
            if sum < 0 {
                break
            }
        }
        if sum >= 0 {
            ans = i
        }
    }
    return ans
}