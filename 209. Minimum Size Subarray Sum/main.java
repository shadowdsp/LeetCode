class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int ans = n + 1, l = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s && l <= i) {
                if (ans > (i - l + 1)) {
                    ans = i - l + 1;
                }
                sum -= nums[l++];
            }
        }
        while (sum >= s && l < n) {
            if (ans > (n - l)) {
                ans = n - l;
            }
            sum -= nums[l++];
        }
        return ans == (n + 1) ? 0 : ans;
    }
}