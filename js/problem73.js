/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    if ((matrix.length === 0) || (matrix[0].length === 0)) {
        return;
    }
    
    let firstRowZero = false, firstColumnZero = false;
    
    for (let i = 0; i < matrix.length; i++) {
        if (matrix[i][0] === 0) {
            firstColumnZero = true;
            break;
        }
    }
    
    for (let j = 0; j < matrix[0].length; j++) {
        if (matrix[0][j] === 0) {
            firstRowZero = true;
            break;
        }
    }
    
    for (let i = 1; i < matrix.length; i++) {
        for (let j = 1; j < matrix[0].length; j++) {
            if (matrix[i][j] === 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    
    for (let i = 1; i < matrix.length; i++) {
        if (matrix[i][0] === 0) {
            for (let j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    
    for (let j = 1; j < matrix[0].length; j++) {
        if (matrix[0][j] === 0) {
            for (let i = 1; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
    
    if (firstRowZero) {
        for (let j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }
    
    if (firstColumnZero) {
        for (let i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }
};