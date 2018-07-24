class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & num) > 0) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += cnt[i] * (n - cnt[i]);
        }
        return ans;
    }
}