class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n <= 0) return 0;
        int m = matrix[0].length;
        if (m <= 0) return 0;
        int ans = 0;
        int[] cnt = new int[m];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (i == 0) cnt[j] = matrix[i][j] - '0';
                else cnt[j] = (matrix[i][j] == '0') ? 0 : (cnt[j] + 1);

            for (int j = 0; j < m; j++) {
                while (!stack.isEmpty() && cnt[stack.peek()] > cnt[j]) {
                    int k = stack.pop();
                    int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                    ans = Math.max(ans, cnt[k] * (j - left));
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int k = stack.pop();
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                ans = Math.max(ans, cnt[k] * (m - left));
            }
        }
        return ans;
    }
}