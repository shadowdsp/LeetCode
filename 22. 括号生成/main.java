class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 0, n, ans, "");
        return ans;
    }
    
    private void dfs(int l, int r, int n, List<String> ans, String str) {
        if (l + r == 2 * n) {
            ans.add(str);
            return ;
        }
        if (r < l) {
            dfs(l, r + 1, n, ans, str + ")");
        }
        if (l < n) {
            dfs(l + 1, r, n, ans, str + "(");
        }
    }
}