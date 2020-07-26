/**
 * @param {number[]} nums
 * @return {number[][]}
 */

const swapValues = function(nums, i, j) {
    if (i === j) {
        return;
    }
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
};

const permuteUtil = function(nums, start, res) {
    if (start === nums.length - 1) {
        res.push(nums.slice());
        return;
    }
    
    for (let i = start; i < nums.length; i++) {
        swapValues(nums, start, i);
        permuteUtil(nums, start + 1, res);
        swapValues(nums, start, i);
    }
};

var permute = function(nums) {
    if (nums.length === 0) {
        return [];
    } else if (nums.length === 1) {
        return [nums];
    }
    
    let res = [];
    
    permuteUtil(nums, 0, res);
    
    return res;
};