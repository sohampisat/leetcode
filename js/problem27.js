/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    if (nums.length === 0) {
        return 0;
    }
    
    let i = 0, j = 0, res = 0;
    
    while (j < nums.length) {
        if (nums[j] === val) {
            j++;
            if (j < nums.length) {
                nums[i] = nums[j];
            }
            res++;
        } else {
            nums[i] = nums[j];
            i++;
            j++;
        }
    }
    
    return nums.length - res;
};