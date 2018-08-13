class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        String ans = "" + nums[0];
        if (n == 1) {
            return ans;
        }
        if (n == 2) {
            ans += "/" + nums[1];
            return ans;
        }
        ans += "/(" + nums[1];
        for (int i = 2; i < n; i++) {
            ans += "/" + nums[i];
        }
        ans += ")";
        return ans;
    }
}