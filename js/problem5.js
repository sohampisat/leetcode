/**
 * @param {string} s
 * @return {string}
 */

const getLongestPalindrome = function(s, i, j) {
    if (s[i] !== s[j]) {
        return null;
    }
    
    while ((i >= 0) && (j < s.length) && (s[i] === s[j])) {
        i--;
        j++;
    }
    
    return [i + 1, j - 1];
};

var longestPalindrome = function(s) {
    if (s.length === 0) {
        return '';
    } else if (s.length === 1) {
        return s;
    }
    
    let res = s[0];
    
    for (let i = 0; i < s.length - 1; i++) {
        let temp = getLongestPalindrome(s, i, i);
        let tempLength = temp[1] - temp[0] + 1;
        if (tempLength > res.length) {
            res = s.slice(temp[0], temp[1] + 1);
        }
        temp = getLongestPalindrome(s, i, i + 1);
        if (temp === null) {
            continue;
        }
        tempLength = temp[1] - temp[0] + 1;
        if (tempLength > res.length) {
            res = s.slice(temp[0], temp[1] + 1);
        }
    }
    
    return res;
};