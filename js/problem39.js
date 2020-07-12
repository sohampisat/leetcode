/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

const getCandidates = function(candidates, target, start, currSum, curr, res) {
    if (currSum >= target) {
        if (currSum === target) {
            res.push(curr.slice());
        }
        return;
    }
    
    for (let i = start; i < candidates.length; i++) {
        curr.push(candidates[i]);
        getCandidates(candidates, target, i, currSum + candidates[i], curr, res);
        curr.pop();
    }
};


var combinationSum = function(candidates, target) {
    if (candidates.length === 0) {
        return [];
    }
    
    let res = [];
    
    for (let i = 0; i < candidates.length; i++) {
        let curr = [candidates[i]];
        getCandidates(candidates, target, i, candidates[i], curr, res);
    }
    
    return res;
};