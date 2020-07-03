/**
 * @param {number} n
 * @return {string[]}
 */

function getParenthesis(n, left, right, current, res) {
    if (current.length === 2 * n) {
        res.push(current);
        return;
    }
    
    if (left < n) {
        getParenthesis(n, left + 1, right, current + '(', res);
    }
    
    if (right < left) {
        getParenthesis(n, left, right + 1, current + ')', res);
    }
}

var generateParenthesis = function(n) {
    if (n === 0) {
        return [];
    }
    
    let res = [];
    getParenthesis(n, 0, 0, '', res);
    return res;
    
};