
class Solution {                
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n <= 0) return 0;
        int ans = 0;
        Stack<Integer> sta = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!sta.isEmpty() && heights[sta.peek()] > heights[i]) {
                int id = sta.pop();
                int left = sta.isEmpty() ? 0 : sta.peek() + 1;
                int area = heights[id] * (i - left);
                if (area > ans) ans = area;
            }
            sta.push(i);
        }
        while (!sta.isEmpty()) {
            int id = sta.pop();
            int left = sta.isEmpty() ? 0 : sta.peek() + 1;
            int area = heights[id] * (n - left);
            if (area > ans) ans = area;
        }
        return ans;
    }
}