/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

const swap = function(nums, i, j) {
    if (i !== j) {
        let temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};

var sortColors = function(nums) {
    if (nums.length < 2) {
        return;
    }
    
    let left = 0, right = nums.length - 1, i = 0;
    
    while (i <= right) {
        if (nums[i] === 0) {
            swap(nums, i, left);
            i++;
            left++;
        } else if (nums[i] === 2) {
            swap(nums, i, right);
            right--;
        } else {
            i++;
        }
    }
};