class Solution {
    public String longestCommonPrefix(String[] strs) {
        int inf = 0x3f3f3f3f;
        int n = strs.length;
        if (n <= 0) return "";
        int len = inf;
        for (int i = 0; i < n; i++) {
            int m = strs[i].length();
            if (m < len) len = m;
        }
        int ans = 0;
        for (int j = 0; j < len; j++) {
            boolean flag = true;
            char c = strs[0].charAt(j);
            for (int i = 1; i < n; i++) {
                if (strs[i].charAt(j) != c) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            ans++;
        }
        return strs[0].substring(0, ans);
    }
}