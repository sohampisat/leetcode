/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

var res = null;

function twoSum(nums, start, target) {
    let i = start + 1, j = nums.length - 1;
    while (i < j) {
        let temp = nums[start] + nums[i] + nums[j];
        if (temp === target) {
            res = target;
            return;
        }
        
        if (Math.abs(target - temp) < Math.abs(target - res)) {
            res = temp;
        }
        
        if (temp < target) {
            i++;
        } else {
            j--;
        }
    }
}

var threeSumClosest = function(nums, target) {
    if (nums.length === 3) {
        return nums[0] + nums[1] + nums[2];
    }
    
    res = Infinity;
    nums.sort(function(a, b) {
        return (+a) - (+b);
    });
    
    for (let i = 0; i < nums.length - 2; i++) {
        if ((i > 0) && (nums[i] === nums[i - 1])) {
            continue;
        }
        
        twoSum(nums, i, target);
        if (res === target) {
            return target;
        }
    }
    
    
    return res;
};