class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n <= 0 || k <= 0 || t < 0) return false;
        HashMap<Long, Long> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long val = (long)nums[i] - Integer.MIN_VALUE;
            long index = val / ((long)t + 1);
            if (mp.containsKey(index) || 
                mp.containsKey(index + 1) && mp.get(index + 1) - val <= t || 
                mp.containsKey(index - 1) && val - mp.get(index - 1) <= t)
                return true;
            if (i >= k) mp.remove(((long)nums[i-k] - Integer.MIN_VALUE) / ((long)t + 1));
            mp.put(index, val);
        }
        return false;
    }
}