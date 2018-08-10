class Solution {
    public String complexNumberMultiply(String a, String b) {
        int n = a.length(), m = b.length();
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '+') {
                x1 = Integer.valueOf(a.substring(0, i));
                y1 = Integer.valueOf(a.substring(i+1, n-1));
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (b.charAt(i) == '+') {
                x2 = Integer.valueOf(b.substring(0, i));
                y2 = Integer.valueOf(b.substring(i+1, m-1));
            }
        }
        int z1 = x1 * x2 - y1 * y2;
        int z2 = x1 * y2 + y1 * x2;
        String ans = "";
        if (z1 == 0) {
            ans += "0+";
        } else {
            ans += z1 + "+";
        }
        if (z2 == 0) {
            ans += "0i";
        } else {
            ans += z2 + "i";
        }
        return ans;
    }
}