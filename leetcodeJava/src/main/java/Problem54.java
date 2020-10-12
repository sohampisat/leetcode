// 54. Spiral Matrix

class Solution {
    
    private void traverseMatrix(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd, List<Integer> res) {
        if ((rowEnd - rowStart + 1 < 1) || (columnEnd - columnStart + 1 < 1)) {
            return;
        }
        for (int j = columnStart; j <= columnEnd; j++) {
            res.add(matrix[rowStart][j]);
        }
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            res.add(matrix[i][columnEnd]);
        }
        if (rowEnd - rowStart > 0) {
            for (int j = columnEnd - 1; j >= columnStart; j--) {
                res.add(matrix[rowEnd][j]);
            }
            if (columnEnd - columnStart > 0) {
                for (int i = rowEnd - 1; i > rowStart; i--) {
                    res.add(matrix[i][columnStart]);
                }
            }
        }
        this.traverseMatrix(matrix, rowStart + 1, rowEnd - 1, columnStart + 1, columnEnd - 1, res);
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        this.traverseMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, res);
        return res;
    }
}