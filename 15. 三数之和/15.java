import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int now = nums[i] + nums[l] + nums[r];
                if (now == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while (l < r && nums[l++] == nums[l]) ;
                    while (l < r && nums[r--] == nums[r]) ;
                } else if (now > 0) {
                    while (l < r && nums[r--] == nums[r]) ;
                } else {
                    while (l < r && nums[l++] == nums[l]) ;
                }
            }
        }
        return lists;
    }
}