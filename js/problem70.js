/**
 * @param {number} n
 * @return {number}
 */

const getSteps = function(n, ht) {
    if (n <= 2) {
        return n;
    }
    
    if (ht.has(n)) {
        return ht.get(n);
    }
    
    let res = getSteps(n - 1, ht) + getSteps(n - 2, ht);
    ht.set(n, res);
    return res;
};

var climbStairs = function(n) {
    if (n === 0) {
        return 0
    }
    
    return getSteps(n, new Map());
};