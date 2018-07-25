class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        if (n <= 0) return 0;
        int m = 2, len = 3, cnt = 0, ans = 1;
        while (len < n) {
            for (int i = 0; i < (sb.charAt(m) - '0') && len < n; i++) {
                if (cnt == 0) {
                    sb.append("1");
                    ans++;
                } else {
                    sb.append("2");
                }
                len++;
            }
            m++;
            cnt ^= 1;
        }
        return ans;
    }
}