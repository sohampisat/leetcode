// 59. Spiral Matrix II

class Solution {
    
    private void fillSpiralMatrix(int[][] matrix, int value, int startRow, int endRow, int startColumn, int endColumn) {
        if (startRow >= endRow) {
            if (startRow == endRow) {
                matrix[startRow][startColumn] = value;
            }
            return;
        }
        for (int j = startColumn; j <= endColumn; j++) {
            matrix[startRow][j] = value++;
        }
        for (int i = startRow + 1; i <= endRow; i++) {
            matrix[i][endColumn] = value++;
        }
        for (int j = endColumn - 1; j >= startColumn; j--) {
            matrix[endRow][j] = value++;
        }
        for (int i = endRow - 1; i > startRow; i--) {
            matrix[i][startColumn] = value++;
        }
        this.fillSpiralMatrix(matrix, value, startRow + 1, endRow - 1, startColumn + 1, endColumn - 1);
    }
    
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][] {};
        } else if (n == 1) {
            return new int[][] {new int[] {1}};
        }
        int[][] res = new int[n][n];
        this.fillSpiralMatrix(res, 1, 0, n - 1, 0, n - 1);
        return res;
    }
}