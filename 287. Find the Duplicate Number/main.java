class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (i + 1 != nums[i]) {
                int target = nums[i] - 1;
                if (nums[target] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[target];
                    nums[target] = temp;
                } else {
                    return nums[target];
                }
            }
        }
        return -1;
    }
}