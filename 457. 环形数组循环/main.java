
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n <= 0) return false;
        int j, k;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            j = k = i;
            j = next(j, nums[j], n);
            k = next(next(k, nums[k], n), nums[next(k, nums[k], n)], n);
            while (nums[i] * nums[j] > 0 && nums[i] * nums[k] > 0) {
                if (j == k) {
                    if (j == next(j, nums[j], n)) {
                        break;
                    }
                    return true;
                }
                j = next(j, nums[j], n);
                k = next(next(k, nums[k], n), nums[next(k, nums[k], n)], n);
            }
            for (j = i; nums[j] * nums[i] > 0; ) {
                k = next(j, nums[j], n);
                nums[j] = 0;
                j = k;
            }
        }
        return false;
    }
    
    private int next(int a, int b, int n) {
        return (a + b + n) % n;
    }
}