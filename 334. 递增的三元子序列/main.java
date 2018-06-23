class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] val = new int[n];
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0 || val[cnt-1] < num) {
                val[cnt++] = num;
            } else {
                int id = find(0, cnt, val, num);
                val[id] = num;
            }
        }
        return cnt > 2;
    }

    int find(int l, int r, int[] val, int num) {
        int ans = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (val[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}