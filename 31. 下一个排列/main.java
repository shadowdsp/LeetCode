class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int id = n - 2;
        while (id >= 0 && nums[id+1] <= nums[id]) {
            id--;
        }
        if (id == -1) {
            Arrays.sort(nums);
            return ;
        } 
        int tmp = -1;
        for (int i = n - 1; i > id; i--) {
            if (nums[i] > nums[id] && (tmp == -1 || nums[tmp] > nums[i])) {
                tmp = i;
            }
        }
        nums[tmp] ^= nums[id];
        nums[id] ^= nums[tmp];
        nums[tmp] ^= nums[id];
        Arrays.sort(nums, id + 1, n);
    }
}