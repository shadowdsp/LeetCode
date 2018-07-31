class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        if (n <= 0) return new int[0];
        int m = matrix[0].length;
        if (m <= 0) return new int[0];
        int[] ans = new int[n*m];
        int x = 0, y = 0, dir = 0;
        int cnt = 0;
        while (cnt < n * m) {
            if (dir == 0) {
                ans[cnt++] = matrix[x--][y++];
                if (y >= m) {
                    x += 2; y = m - 1;
                    dir ^= 1;
                } else if (x < 0) {
                    x = 0;
                    dir ^= 1;
                }
            } else {
                ans[cnt++] = matrix[x++][y--];
                if (x >= n) {
                    x = n - 1; y += 2;
                    dir ^= 1;
                } else if (y < 0) {
                    y = 0;
                    dir ^= 1;
                }
            }
        }
        return ans;
    }
}