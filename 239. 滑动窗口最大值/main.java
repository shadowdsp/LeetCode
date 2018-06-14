class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n <= 0 || k <= 0) return new int[0];
        int[] que = new int[n+1];
        int head = 0, tail = 0;
        int[] ans = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            while (head > tail && (nums[que[tail]] <= nums[i] || que[tail] <= i - k))
                tail++;
            while (head > tail && nums[que[head-1]] <= nums[i])
                head--;
            que[head++] = i;
            if (i >= k - 1) ans[i-k+1] = nums[que[tail]];
        }
        return ans;
    }
}