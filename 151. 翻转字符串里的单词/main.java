class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        char[] c = s.toCharArray();
        int n = c.length;
        rever(0, n - 1, c);
        int l = 0, r = 0, blank = 0;
        while (l < n && r < n) {
            while (r < n && c[r] == ' ') {
                r++;
            }
            if (blank > 0) {
                c[l++] = ' ';
            }
            int pos = l;
            while (r < n && c[r] != ' ') {
                c[l++] = c[r++];
            }
            rever(pos, l - 1, c);
            blank++;
        }
        return new String(c).substring(0, l).trim();
    }
    
    void rever(int l, int r, char[] c) {
        while (l < r) {
            char tmp = c[l];
            c[l] = c[r];
            c[r] = tmp;
            l++; r--;
        }
    }
}