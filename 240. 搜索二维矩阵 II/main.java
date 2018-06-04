class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n <= 0) return false;
        int m = matrix[0].length;
        if (m <= 0) return false;
        int row = 0, col = m - 1;
        while (0 <= row && row < n && 0 <= col && col < m) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}