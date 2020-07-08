/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    if (nums.length < 2) {
        return;
    }
    
    if (nums.length === 2) {
        let temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;
        return;
    }
    
    for (var i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            break;
        }
    }
    
    if (i === nums.length - 2) {
        let temp = nums[i];
        nums[i] = nums[i + 1];
        nums[i + 1] = temp;
        return;
    }
    
    if (i !== -1) {
        let tempMin = nums[i + 1], tempMinIndex = i + 1;
        for (let j = i + 2; j < nums.length; j++) {
            if ((nums[j] > nums[i]) && (nums[j] <= tempMin)) {
                tempMin = nums[j];
                tempMinIndex = j;
            }
        }
        
        let temp = nums[i];
        nums[i] = nums[tempMinIndex];
        nums[tempMinIndex] = temp;
    }
    
    let l = i + 1, r = nums.length - 1;
    while (l < r) {
        let temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
    }
    
};