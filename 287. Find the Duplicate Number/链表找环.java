class Solution {
    public int findDuplicate(int[] nums) {
        // 从n开始的原因是题意说数字只会在1~n-1之间出现，避免了初始有环
        int n = nums.length;
        if (n > 0) {
            int slow = n;
            int fast = n;
            do {
                slow = nums[slow-1];
                fast = nums[nums[fast-1]-1];
            } while (slow != fast);
            slow = n;
            while (slow != fast) {
                slow = nums[slow-1];
                fast = nums[fast-1];
            }
            return slow;
        }
        return -1;
    }
}