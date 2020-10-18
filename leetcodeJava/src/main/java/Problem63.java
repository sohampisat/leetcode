// 63. Unique Paths II

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ((obstacleGrid.length == 1) && (obstacleGrid[0].length == 1)) {
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            return 1;
        } else if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        if (obstacleGrid[rows - 1][columns - 1] == 1) {
            return 0;
        }
        int[][] paths = new int[rows][columns];
        for (int j = columns - 2; j >= 0; j--) {
            if (obstacleGrid[rows - 1][j] == 1) {
                break;
            }
            paths[rows - 1][j] = 1;
        }
        for (int i = rows - 2; i >= 0; i--) {
            if (obstacleGrid[i][columns - 1] == 1) {
                break;
            }
            paths[i][columns - 1] = 1;
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
            }
        }
        return paths[0][0];
    }
}