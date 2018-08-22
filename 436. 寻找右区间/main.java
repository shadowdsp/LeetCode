/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        HashMap<Integer, Integer> st = new HashMap<>(0);
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int s = intervals[i].start;
            list.add(s);
            st.put(s, i);
        }
        Collections.sort(list);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1, res = -1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (list.get(mid) < intervals[i].end) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    res = mid;
                }
            }
            ans[i] = res == -1 ? -1 : st.get(list.get(res));
        }
        return ans;
    }
}