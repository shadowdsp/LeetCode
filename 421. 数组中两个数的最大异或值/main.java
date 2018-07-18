class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            mask |= (1 << i);
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = ans | (1 << i);
            for (int num : set) {
                if (set.contains(num ^ tmp)) {
                    ans = tmp;
                    break;
                }
            }
        }
        return ans;
    }
}