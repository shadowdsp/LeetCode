class Solution {
    // Set<List<Integer>> set;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        // set = new HashSet<>();
        ans = new ArrayList<>();
        dfs(k, n, 0, 0L);
        return ans;
    }
    
    void dfs(int k, int n, int pre, long val) {
        if (k == 0 && n == 0) {
            List<Integer> list = new ArrayList<>();
            while (val > 0) {
                list.add((int)(val % 10));
                val /= 10;
            }
            ans.add(list);
            return ;
        }
        if (k == 0 || n < 0) return ;
        for (int i = pre + 1; i < 10; i++) {
            dfs(k - 1, n - i, i, val * 10 + i);
        }
    }
}