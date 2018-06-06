class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int n = Math.min(a.length, b.length);
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(a[i]);
            int q = Integer.parseInt(b[i]);
            if (p < q) return -1;
            else if (p > q) return 1;
        }
        if (a.length < b.length) {
            for (int i = n; i < b.length; i++) 
                if (Integer.parseInt(b[i]) != 0) 
                    return -1;
        } else if (a.length > b.length) {
            for (int i = n; i < a.length; i++) 
                if (Integer.parseInt(a[i]) != 0) 
                    return 1;
        }
        return 0;
    }
}