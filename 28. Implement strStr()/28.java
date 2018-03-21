class Solution {
    // kmp
    public int strStr(String haystack, String needle) {
        int n = haystack.length(); int m = needle.length();
        if (m == 0) return 0;

        // build next[]
        int[] nxt = new int[m+1];
        nxt[0] = -1;
        int i = 0, j = -1;
        while (i < m - 1) {
            while (j != -1 && needle.charAt(j) != needle.charAt(i)) j = nxt[j];
            if (needle.charAt(++j) == needle.charAt(++i)) nxt[i] = nxt[j]; // advance
            else nxt[i] = j;
        }

        // kmp
        i = 0; j = 0;
        while (i < n) {
            while (j != -1 && needle.charAt(j) != haystack.charAt(i)) j = nxt[j];
            ++i; ++j;
            if (j >= m) return i - m;
        }
        return -1;
    }
}