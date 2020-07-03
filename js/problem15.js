/**
 * @param {number[]} nums
 * @return {number[][]}
 */


var res = null;


function twoSum(nums, start) {
    let i = start + 1, j = nums.length - 1;
    while (i < j) {
        
        let temp = nums[start] + nums[i] + nums[j];
        if (temp === 0) {
            res.push([nums[start], nums[i], nums[j]]);
            i++;
            while ((i < j) && (nums[i] === nums[i - 1])) {
                i++;
            }
            j--;
            while ((i < j) && (nums[j] === nums[j + 1])) {
                j--;
            }
        } else if (temp < 0) {
            i++;
        } else {
            j--;
        }
    }
}

var threeSum = function(nums) {
    
    if (nums.length < 3) {
        return [];
    }
    
    res = [];
    
    nums = nums.sort(function(a, b) {
        return (+a) - (+b);
    });
    
    for (let i = 0; i < nums.length - 2; i++) {
        if ((i > 0) && (nums[i] === nums[i - 1])) {
            continue;
        }
        
        twoSum(nums, i);
    }
    
    return res;
};