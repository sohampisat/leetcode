/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    if (nums.length < 2) {
        return true;
    }
    
    let minJumps = new Array(nums.length);
    minJumps[0] = 0;
    
    for (let i = 1; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if (i <= j + nums[j]) {
                if (!minJumps[i]) {
                    minJumps[i] = minJumps[j] + 1;
                } else {
                    minJumps[i] = Math.min(minJumps[i], minJumps[j] + 1);
                }
            }
        }
        if (!minJumps[i]) {
            return false;
        }
    }
    
    return true;
};