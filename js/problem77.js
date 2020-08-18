/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */

const getCombination = function(n, k, first, curr, res) {
    if (curr.length === k) {
        res.push(curr.slice());
        return;
    }
    
    if (first > n) {
        return;
    }
    
    for (let i = first; i <= n; i++) {
        curr.push(i);
        getCombination(n, k, i + 1, curr, res);
        curr.pop();
    }
};


var combine = function(n, k) {
    if (k === 0) {
        return [];
    } else if (n <= k) {
        let res = [];
        for (let i = 1; i <= n; i++) {
            res.push(i);
        }
        return [res];
    }
    
    let res = [];
    getCombination(n, k, 1, [], res);
    return res;
};