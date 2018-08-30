class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int v = i;
            while (!vis[v]) {
                vis[v] = true;
                cnt++;
                v = nums[v];
            }
            ans = cnt > ans ? cnt : ans;
        }
        return ans;
    }
}