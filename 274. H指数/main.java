class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int h = 0, l = 0, r = 0x3f3f3f3f;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, citations)) {
                l = mid + 1;
                h = mid;
            } else {
                r = mid - 1;
            }
        } 
        return h;
    }
    
    boolean check(int mid, int[] citations) {
        int n = citations.length;
        int cnt = 0;
        for (int num : citations) 
            if (mid <= num) cnt++;
        return cnt >= mid;
    }
}