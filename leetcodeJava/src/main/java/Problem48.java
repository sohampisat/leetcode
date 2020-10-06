// 48. Rotate Image

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            int i = 0;
            int j = matrix.length - 1;
            while (i < j) {
                int temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
                i++;
                j--;
            }
        }
    }
}