class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n <= 1) return 0;
        Collections.sort(timePoints, (o1, o2) -> {
            String[] str1 = o1.split(":");
            int h1 = Integer.parseInt(str1[0]), m1 = Integer.parseInt(str1[1]);
            String[] str2 = o2.split(":");
            int h2 = Integer.parseInt(str2[0]), m2 = Integer.parseInt(str2[1]);
            if (h1 == h2) {
                return m1 - m2;
            }
            return h1 - h2;
        });
        int mx = 10000000;
        timePoints.add(timePoints.get(0));
        n = timePoints.size();
        for (int i = 1; i < n; i++) {
            String[] str1 = timePoints.get(i-1).split(":");
            int h1 = Integer.parseInt(str1[0]), m1 = Integer.parseInt(str1[1]);
            String[] str2 = timePoints.get(i).split(":");
            int h2 = Integer.parseInt(str2[0]), m2 = Integer.parseInt(str2[1]);
            if (m1 > m2) {
                m2 += 60;
                h2--;
            }
            if (h1 > h2) {
                h2 += 24;
            }
            int now = (h2 - h1) * 60 + (m2 - m1);
            if (now < mx) {
                mx = now;
            }
        }
        return mx;
    }
}