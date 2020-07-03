/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if (s.length < 2) {
        return s.length;
    } 
    
    let res = 1;
    
    let ht = new Map();
    ht.set(s[0], 0);
    
    let i = 0, j = 1;
    
    while (j < s.length) {
        let temp = ht.get(s[j]);
        if ((temp === undefined) || (temp < i)) {
            res = Math.max(res, (j - i + 1));
            ht.set(s[j], j);
            j++;
        } else {
            i = temp + 1;
            if (i === j) {
                j++;
                ht = new Map();
                ht.set(s[i], i);
            }
        }
    }
    
    return res;
};