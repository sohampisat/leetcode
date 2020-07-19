/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    if (matrix.length < 2) {
        return;
    }
    
    for (let i = 0; i < matrix.length - 1; i++) {
        for (let j = i + 1; j < matrix.length; j++) {
            let temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    
    for (let row = 0; row < matrix.length; row++) {
        let i = 0, j = matrix.length - 1;
        while (i < j) {
            let temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }
};