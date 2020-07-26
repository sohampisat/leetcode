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

const permuteUtil = function(nums, start, ht) {
    if (start === nums.length - 1) {
        let numsKey = nums.join();
        if (!ht.has(numsKey)) {
            ht.set(numsKey, nums.slice());
        }
        return;
    }
    
    for (let i = start; i < nums.length; i++) {
        swapValues(nums, start, i);
        permuteUtil(nums, start + 1, ht);
        swapValues(nums, start, i);
    }
};

var permuteUnique = function(nums) {
    if (nums.length === 0) {
        return [];
    } else if (nums.length === 1) {
        return [nums];
    }
    
    let ht = new Map();
    permuteUtil(nums, 0, ht);
    
    let res = [];
    
    ht.forEach(function(value, key) {
        res.push(value);
    });
    
    return res;
};