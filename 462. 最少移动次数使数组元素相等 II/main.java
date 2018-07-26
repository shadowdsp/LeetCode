class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length <= 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - nums[n/2]);
        }
        return ans;
    }
}