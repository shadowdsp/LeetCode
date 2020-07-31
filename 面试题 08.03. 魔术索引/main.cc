class Solution {
public:
    int dfs(int l, int r, vector<int>& nums) {
        if (l > r) {
            return -1;
        }
        int m = (l + r) >> 1;
        int ret = dfs(l, m - 1, nums);
        if (ret != -1) {
            return ret;
        } else if (nums[m] == m) {
            return m;
        }
        return dfs(m + 1, r, nums);
    }

    int findMagicIndex(vector<int>& nums) {
        return dfs(0, nums.size() - 1, nums);
    }
};