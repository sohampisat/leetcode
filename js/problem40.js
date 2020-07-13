/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

const getCandidates = function(nums, target, start, currSum, curr, res) {
    if (currSum >= target) {
        if (currSum === target) {
            res.push(curr.slice());
        }
        return;
    }
    
    for (let i = start + 1; i < nums.length; i++) {
        if ((i > start + 1) && (nums[i] === nums[i - 1])) {
            continue;
        }
        curr.push(nums[i]);
        getCandidates(nums, target, i, currSum + nums[i], curr, res);
        curr.pop();
    }
};

var combinationSum2 = function(candidates, target) {
    if (candidates.length === 0) {
        return [];
    }
    
    let res = [];
    candidates.sort(function(a, b) {
        return (+a) - (+b);
    });
    
    for (let i = 0; i < candidates.length; i++) {
        if((i > 0) && (candidates[i] === candidates[i - 1])) {
            continue;
        }
        let curr = [candidates[i]];
        getCandidates(candidates, target, i, candidates[i], curr, res);
    }
    
    return res;
};