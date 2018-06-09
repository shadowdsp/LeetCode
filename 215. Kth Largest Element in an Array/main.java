class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = nums[0], r = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < l) l = nums[i];
            if (nums[i] > r) r = nums[i];
        }
        int ans = r;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (cal(mid, nums) >= k) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    
    int cal(int val, int[] nums) {
        int cnt = 0;
        for (int v : nums) 
            if (v >= val) cnt++;
        return cnt;
    }
}