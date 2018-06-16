class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum ^= num;
        int[] ans = new int[2];
        int pos = 0;
        while ((sum & (1 << pos)) == 0) pos++;
        for (int num : nums) {
            if ((num & (1 << pos)) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}