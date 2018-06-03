class Solution {
    public String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int n = s1.length, m = s2.length;
        int[] ans = new int[n+m+1];
        if (n <= 0 || m <= 0) {
            return "";
        } else if (s1[0] == '0' || s2[0] == '0') {
            return "0";
        }
        for (int i = 0; i < n+m+1; i++) ans[i] = -1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int a = s1[j] - '0', b = s2[i] - '0';
                int mul = a * b;
                int bit1 = m - i - 1, bit2 = n - j - 1;
                if (ans[bit1 + bit2] == -1) ans[bit1 + bit2] = 0;
                ans[bit1 + bit2] += mul % 10;
                if ((mul / 10) > 0 && ans[bit1 + bit2 + 1] == -1) ans[bit1 + bit2 + 1] = 0;
                ans[bit1 + bit2 + 1] += mul / 10;
            }
        }
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while (ans[len] != -1) {
            if (ans[len] > 9) {
                if (ans[len + 1] == -1) ans[len+1] = 0;
                ans[len+1] += ans[len] / 10;
                ans[len] %= 10;
            }
            sb.append(ans[len++]);
        }
        return sb.reverse().toString();
    }
}