class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        if (n <= 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>(0);
        int ans = 0;
        for (List<Integer> aWall : wall) {
            int sum = 0;
            for (int j = 0; j < aWall.size() - 1; j++) {
                sum += aWall.get(j);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
                if (map.get(sum) > ans) {
                    ans = map.get(sum);
                }
            }
        }
        return n - ans;
    }
}