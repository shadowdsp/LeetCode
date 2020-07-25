class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        long long l = 0, r = 0;
        for (int i = 0; i < nums.size(); i++) {
            r += nums[i];
            l = max((int)l, nums[i]);
        }
        while (l < r) {
            long long sum = (l + r) / 2;
            if (check(nums, sum, m)) {
                r = sum;
            } else {
                l = sum + 1;
            }
        }
        return l;
    }

    bool check(vector<int>&nums, long long sum, int m) {
        int cnt = 1;
        long long tot = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (tot + nums[i] > sum) {
                cnt++;
                tot = nums[i];
            } else {
                tot += nums[i];
            }
        }
        return cnt <= m;
    }
};