class Solution {
    public int divide(int dividend, int divisor) {
        long a = dividend, b = divisor;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int rev = 1;
        if (a < 0) rev = -rev;
        if (b < 0) rev = -rev;
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        
        List<Long> list = new ArrayList<>();
        long p = 1;
        while (b <= a) {
            list.add(b);
            b += b;
            p += p;
        }
        int ans = 0;
        long sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            p >>= 1;
            if (sum + list.get(i) <= a) {
                sum += list.get(i);
                ans += p;
            }
        }
        return rev * ans;
    }
}