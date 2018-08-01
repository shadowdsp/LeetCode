class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] p = new int[2*n];
        for (int i = 0; i < n; i++) {
            p[i] = nums[i];
        }
        for (int i = n; i < 2 * n; i++) {
            p[i] = nums[i-n];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + i; j++) {
                if (nums[i] < p[j]) {
                    nums[i] = p[j];
                    break;
                }
            }
            if (nums[i] == p[i]) {
                nums[i] = -1;
            }
        }
        return nums;
    }
}