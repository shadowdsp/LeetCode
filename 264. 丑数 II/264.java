class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 5) return n;
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int now = Math.min(res.get(a) * 2, Math.min(res.get(b) * 3, res.get(c) * 5));
            if (now == res.get(a) * 2) a++;
            if (now == res.get(b) * 3) b++;
            if (now == res.get(c) * 5) c++;
            res.add(now);
        }
        return res.get(n-1);
    }
}