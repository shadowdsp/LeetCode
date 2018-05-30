class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows <= 0) {
            return ans;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> now = new ArrayList<>();
            if (i == 0) {
                now.add(1);
            } else {
                now.add(ans.get(i-1).get(0));
                for (int j = 1; j < ans.get(i-1).size(); j++) {
                    now.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
                }
                now.add(ans.get(i-1).get(ans.get(i-1).size() - 1));
            }
            ans.add(now);
        }
        return ans;
    }
}