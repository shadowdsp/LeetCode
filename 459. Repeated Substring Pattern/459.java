class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] nxt = new int[n+1];
        int j = nxt[0] = -1, i = 0;
        s += " ";
        while (i < n) {
            if (j == -1 || ( s.charAt(i) == s.charAt(j))) {
                ++j; ++i; nxt[i] = j;
            } else {
                j = nxt[j];
            }
        }
        // 循环节长度刚好取余
        return (nxt[n] > 0) && (nxt[n] % (n - nxt[n])) == 0;
    }
}