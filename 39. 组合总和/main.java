class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0) return ans;
        dfs(ans, new ArrayList<Integer>(0), candidates, 0, n, 0, target);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> now, int[] candidates, int id, int n, int sum, int target) {
        if (id >= n || sum >= target) {
            if (sum == target) {
                ans.add(new ArrayList<>(now));
            }
            return ;
        }
        for (int i = id; i < n; i++) {
            now.add(candidates[i]);
            dfs(ans, now, candidates, i, n, sum + candidates[i], target);
            now.remove(now.size() - 1);
        }
    }
}