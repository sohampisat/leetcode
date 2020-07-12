/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */


const binarySearch = function(nums, target, start, end) {
    let length = end - start + 1;
    if (length === 1) {
        if (target <= nums[start]) {
            return start;
        }
        return start + 1;
    } else if (length === 2) {
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        }
        return end + 1;
    }
    
    let mid = Math.floor((start + end) / 2);
    if (nums[mid] === target) {
        return mid;
    }
    
    if (target < nums[mid]) {
        return binarySearch(nums, target, start, mid - 1);
    }
    
    return binarySearch(nums, target, mid + 1, end);
    
};

var searchInsert = function(nums, target) {
    if (nums.length === 0) {
        return 0;
    }
    
    return binarySearch(nums, target, 0, nums.length - 1);
};