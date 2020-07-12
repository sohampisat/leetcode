/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */


const binarySearch = function(nums, target, start, end) {
    let length = end - start + 1;
    if (length === 1) {
        if (nums[start] === target) {
            return [start, start];
        }
        return [-1, -1];
    } else if (length === 2) {
        if (nums[start] === target && nums[end] === target) {
            return [start, end];
        } else if (nums[start] === target) {
            return [start, start];
        } else if (nums[end] === target) {
            return [end, end];
        } else {
            return [-1, -1];
        }
    }
    
    let mid = Math.floor((start + end) / 2);
    if (nums[mid] === target) {
        let res = [mid, mid];
        if (nums[mid - 1] === target) {
            res[0] = binarySearch(nums, target, start, mid - 1)[0];
        }
        
        if (nums[mid + 1] === target) {
            res[1] = binarySearch(nums, target, mid + 1, end)[1];
        }
        
        return res;
    }
    
    if (target < nums[mid]) {
        return binarySearch(nums, target, start, mid - 1);
    }
    
    return binarySearch(nums, target, mid + 1, end);
};

var searchRange = function(nums, target) {
    if (nums.length === 0) {
        return [-1, -1];
    }
    
    return binarySearch(nums, target, 0, nums.length - 1);
};