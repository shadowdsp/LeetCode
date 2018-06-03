class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] ans = new int[n+m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int cur = mul + ans[p2];
                ans[p1] += cur / 10;
                ans[p2] = cur % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            if (sb.length() > 0 || num > 0) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}