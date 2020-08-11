/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */


const binarySearch = function(nums, start, end, target) {
    let length = end - start + 1;
    if (length === 0) {
        return false;
    }
    
    if (length <= 2) {
        return (nums[start] === target) || (nums[end] === target);
    }
    
    let mid = Math.floor((start + end) / 2);
    if (nums[mid] === target) {
        return true;
    }
    
    if (target < nums[mid]) {
        return binarySearch(nums, start, mid - 1, target);
    }
    
    return binarySearch(nums, mid + 1, end, target);
};

const matrixBinarySearch = function(matrix, start, end, target) {
    let length = end - start + 1;
    if (length === 1) {
        return binarySearch(matrix[start], 0, matrix[0].length - 1, target);
    } else if (length === 2) {
        if (target < matrix[end][0]) {
            return binarySearch(matrix[start], 0, matrix[0].length - 1, target);
        }
        return binarySearch(matrix[end], 0, matrix[0].length - 1, target);
    } 
    
    let mid = Math.floor((start + end) / 2);
    if (matrix[mid][0] === target) {
        return true;
    }
    
    if (target < matrix[mid][0]) {
        return matrixBinarySearch(matrix, start, mid - 1, target);
    }
    
    return matrixBinarySearch(matrix, mid, end, target);
};

var searchMatrix = function(matrix, target) {
    if ((matrix.length === 0) || (matrix[0].length === 0)) {
        return false;
    }
    
    return matrixBinarySearch(matrix, 0, matrix.length - 1, target);
};