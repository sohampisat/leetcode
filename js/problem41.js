/**
 * @param {number[]} nums
 * @return {number}
 */


const checkOnePresent = function(nums) {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 1) {
            return true;
        }
    }
    return false;
};

var firstMissingPositive = function(nums) {
    if (nums.length === 0) {
        return 1;
    } else if (nums.length === 1) {
        if (nums[0] === 1) {
            return 2;
        }
        return 1;
    }
    
    if (!checkOnePresent(nums)) {
        return 1;
    }
    
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 1) {
            nums[i] = 1;
        }
    }
    
    let nPresent = false;
    
    for (let i = 0; i < nums.length; i++) {
        let temp = Math.abs(nums[i]);
        if (temp >= nums.length) {
            if (temp === nums.length) {
                nPresent = true;
            }
            continue;
        }
        
        if (nums[temp] > 0) {
            nums[temp] *= -1; 
        }
    }
    
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > 0) {
            return i;
        }
    }
    
    if (!nPresent) {
        return nums.length;
    }
    
    return nums.length + 1;
};