class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if (n <= 0) return ans;
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i-1] == 1) continue;
            if (pre != nums[i-1]) ans.add(pre + "->" + nums[i-1]);
            else ans.add("" + pre);
            pre = nums[i];
        }
        if (pre != nums[n-1]) ans.add(pre + "->" + nums[n-1]);
        else ans.add("" + pre);
        return ans;
    }
}