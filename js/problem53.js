/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    if (nums.length === 1) {
        return nums[0];
    }
    
    let tempMax = nums[0], res = nums[0];
    
    for (let i = 1; i < nums.length; i++) {
        tempMax = ((tempMax + nums[i]) > nums[i]) ? tempMax + nums[i] : nums[i];
        res = (tempMax > res) ? tempMax : res;
    }
    
    return res;
};