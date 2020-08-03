/**
 * @param {number[][]} grid
 * @return {number}
 */

const getMinSum = function(grid, i, j, ht) {
    
    if ((i === grid.length - 1) && (j === grid[0].length - 1)) {
        return grid[i][j];
    }
    
    let key = `${i},${j}`;
    if (ht.has(key)) {
        return ht.get(key);
    }
    
    let minRight = null, minDown = null, res = grid[i][j];
    
    if (j < grid[0].length - 1) {
        minRight = getMinSum(grid, i, j + 1, ht);
    }
    if (i < grid.length - 1) {
        minDown = getMinSum(grid, i + 1, j, ht);
    }
    
    if (minRight === null) {
        res += minDown;
    } else if (minDown === null) {
        res += minRight;
    } else {
        res += Math.min(minRight, minDown);
    }
    
    ht.set(key, res);
    return res;
};


var minPathSum = function(grid) {
    if ((grid.length === 0) || (grid[0].length === 0)) {
        return 0;
    }
    
    return getMinSum(grid, 0, 0, new Map());
};