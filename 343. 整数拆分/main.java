class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n % 3 == 0) {
            return f_pow(3, n / 3);
        } else if (n % 3 == 1) {
            return 2 * 2 * f_pow(3, (n-4) / 3);
        } else {
            return 2 * f_pow(3, (n-2) / 3);
        }
    }
    
    private int f_pow(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if (b % 2 == 1) ans *= a;
            a *= a;
            b >>= 1;
        }
        return ans;
    }
}