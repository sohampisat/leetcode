/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */


const findPaths = function(m, n, i, j, ht) {
    if ((i === m - 1) && (j === n - 1)) {
        return 1;
    }
    
    let key = `${i},${j}`;
    if (ht.has(key)) {
        return ht.get(key);
    }
    
    let res = 0;
    if (i < m - 1) {
        res += findPaths(m, n, i + 1, j, ht);
    }
    
    if (j < n - 1) {
        res += findPaths(m, n, i, j + 1, ht);
    }
    
    ht.set(key, res);
    return res;
}

var uniquePaths = function(m, n) {
    if ((m === 1) || (n === 1)) {
        return 1;
    }
    
    let ht = new Map();
    return findPaths(m, n, 0, 0, ht);
};