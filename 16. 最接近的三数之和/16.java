class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3) return 0;
        int dif = 0x3f3f3f3f, ans = -1;
        
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int now = nums[i] + nums[l] + nums[r];
                if (Math.abs(now - target) < dif) {
                    dif = Math.abs(now - target);
                    ans = now;
                } 
                if (now > target) r--;
                else if (now < target) l++;
                else break;
            }
        }
        return ans;
    }
}