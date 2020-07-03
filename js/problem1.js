/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    if (nums.length < 2) {
        return [];
    }
    
    if (nums.length == 2) {
        if (nums[0] + nums[1] === target) {
            return [0, 1];
        }
        return [];
    }
    
    let ht = new Map();
    ht.set(nums[0], 0);
    
    for (let i = 1; i < nums.length; i++) {
        let diff = target - nums[i];
        if (ht.has(diff)) {
            return [ht.get(diff), i];
        }
        ht.set(nums[i], i);
    }
    
    return [];
};