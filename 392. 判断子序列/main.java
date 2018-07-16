class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if (n <= 0) return true;
        if (m <= 0) return false;
        int l = 0, r = 0;
        while (r < m) {
            if (s.charAt(l) == t.charAt(r)) 
                l++;
            if (l == n) return true;
            r++;
        }
        return false;
    }
}