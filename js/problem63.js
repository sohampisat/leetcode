/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */

const findPaths = function(grid, i, j, ht) {
    if (grid[i][j] === 1) {
        return 0;
    } else if ((i === grid.length - 1) && (j === grid[0].length - 1)) {
        return 1;
    }
    
    let key = `${i},${j}`;
    if (ht.has(key)) {
        return ht.get(key);
    }
    
    let res = 0;
    if (i < grid.length - 1) {
        res += findPaths(grid, i + 1, j, ht);
    }
    if (j < grid[0].length - 1) {
        res += findPaths(grid, i, j + 1, ht);
    }
    ht.set(key, res);
    return res;
};

var uniquePathsWithObstacles = function(obstacleGrid) {
    if (obstacleGrid.length === 0) {
        return 0;
    }
    
    if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] === 1) {
        return 0;
    }
    
    let ht = new Map();
    return findPaths(obstacleGrid, 0, 0, ht);
};