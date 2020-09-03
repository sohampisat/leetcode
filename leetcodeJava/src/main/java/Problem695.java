// 695. Max Area of Island

class Solution {
    
    private int exploreIsland(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        int res = 0;
        
        if ((i > 0) && (grid[i - 1][j] == 1)) {
            res += this.exploreIsland(grid, i - 1, j);
        }
        if ((j < grid[0].length - 1) && (grid[i][j + 1] == 1)) {
            res += this.exploreIsland(grid, i, j + 1);
        }
        if ((i < grid.length - 1) && (grid[i + 1][j] == 1)) {
            res += this.exploreIsland(grid, i + 1, j);
        }
        if ((j > 0) && (grid[i][j - 1] == 1)) {
            res += this.exploreIsland(grid, i, j - 1);
        }
        
        return res + 1;
    } 
    
    public int maxAreaOfIsland(int[][] grid) {
        if ((grid.length == 0) || (grid[0].length == 0)) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int islandArea = this.exploreIsland(grid, i, j);
                    if (islandArea > res) {
                        res = islandArea;
                    }
                }
            }
        }
        return res;
    }
}