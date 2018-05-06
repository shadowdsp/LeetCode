/**
 * Definition for an interval.
 * type Interval struct {
 *	   Start int
 *	   End   int
 * }
 */
 func merge(intervals []Interval) []Interval {
    n := len(intervals)
    st := make([]int, n)
    ed := make([]int, n)
    ans := make([]Interval, 0)
    for i := 0; i < n; i++ {
        st[i] = intervals[i].Start
        ed[i] = intervals[i].End
    }	
    
    sort.Ints(st)
    sort.Ints(ed)
    
    for i, j := 0, 0; i < n; i++ {
        if i == n - 1 || st[i+1] > ed[i] {
            ans = append(ans, Interval{st[j], ed[i]})
            j = i + 1
        }
    }
    
    return ans
}