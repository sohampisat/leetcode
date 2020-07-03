/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */

let res = null;

function twoSum(nums, target, currentSum, start) {
    let i = start + 1, j = nums.length - 1;
    while (i < j) {
        let temp = currentSum + nums[start] + nums[i] + nums[j];
        if (temp === target) {
            res.push([currentSum, nums[start], nums[i], nums[j]]);
            i++;
            while ((i < j) && (nums[i] === nums[i - 1])) {
                i++;
            }
            j--;
            while ((i < j) && (nums[j] === nums[j + 1])) {
                j--;
            }
        } else if (temp < target) {
            i++;
        } else {
            j--;
        }
    }
}

function threeSum(nums, target, start) {
    for (let i = start + 1; i < nums.length - 2; i++) {
        if ((i > start + 1) && (nums[i] === nums[i - 1])) {
            continue;
        }
        twoSum(nums, target, nums[start], i);
    }
}

var fourSum = function(nums, target) {
    if (nums.length < 4) {
        return [];
    }
    
    res = [];
    
    nums.sort(function(a, b) {
        return (+a) - (+b); 
    });
    
    for (let i = 0; i < nums.length - 3; i++) {
        if ((i > 0) && (nums[i] === nums[i - 1])) {
            continue;
        }
        threeSum(nums, target, i);
    }
    
    return res;
    
};