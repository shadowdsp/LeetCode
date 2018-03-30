class Solution {
    public void rotate(int[][] matrix) {
        // i表示层数，j表示每一层的一个方向元素个数
        int n = matrix.length;
        int d = (n - 1) / 2;
        for (int i = 0; i <= d; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}