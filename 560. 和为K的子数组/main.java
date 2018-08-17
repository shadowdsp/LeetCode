class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>(0);
        int sum = 0, ans = 0;
        hash.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (hash.containsKey(sum - k)) {
                ans += hash.get(sum - k);
            }
            if (hash.containsKey(sum)) {
                hash.put(sum, hash.get(sum) + 1);
            } else {
                hash.put(sum, 1);
            }
        }
        return ans;
    }
}