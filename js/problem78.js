/**
 * @param {number[]} nums
 * @return {number[][]}
 */

const backtrack = (nums, first, curr, res) => {
    res.push(curr.slice());
    if (first === nums.length) {
        return;
    }
    
    for (let i = first; i < nums.length; i++) {
        curr.push(nums[i]);
        backtrack(nums, i + 1, curr, res);
        curr.pop();
    }
};

var subsets = function(nums) {
    if (nums.length === 0) {
        return [];
    }
    
    let res = [[]];
    for (let i = 0; i < nums.length; i++) {
        backtrack(nums, i + 1, [nums[i]], res);
    }
    return res;
};