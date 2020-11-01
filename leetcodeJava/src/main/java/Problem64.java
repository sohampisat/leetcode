// 64. Minimum Path Sum

class Solution {
    public int minPathSum(int[][] grid) {
        if ((grid.length == 1) && (grid[0].length == 1)) {
            return grid[0][0];
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] cost = new int[rows][columns];
        cost[rows - 1][columns - 1] = grid[rows - 1][columns - 1];
        for (int j = columns - 2; j >= 0; j--) {
            cost[rows - 1][j] = grid[rows - 1][j] + cost[rows - 1][j + 1];
        }
        for (int i = rows - 2; i >= 0; i--) {
            cost[i][columns - 1] = grid[i][columns - 1] + cost[i + 1][columns -1];
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = columns - 2; j >= 0; j--) {
                cost[i][j] = grid[i][j] + Math.min(cost[i + 1][j], cost[i][j + 1]);
            }
        }
        return cost[0][0];
    }
}