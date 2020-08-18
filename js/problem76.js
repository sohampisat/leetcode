/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if (s.length === 0 || t.length === 0) {
        return '';
    } else if (s.length < t.length) {
        return '';
    }
    
    let ht = new Map();
    for (let i = 0; i < t.length; i++) {
        let temp = ht.get(t[i]);
        if (temp) {
            ht.set(t[i], temp + 1);
        } else {
            ht.set(t[i], 1);
        }
    }
    
    let required = ht.size, formed = 0;
    let left = 0, right = 0;
    let tempHT = new Map();
    let ans = [-1, 0, 0];
    
    while (right < s.length) {
        let temp1 = tempHT.get(s[right]);
        if (temp1) {
            tempHT.set(s[right], temp1 + 1);
        } else {
            tempHT.set(s[right], 1);
        }
        
        if ((ht.has(s[right])) && (ht.get(s[right]) === tempHT.get(s[right]))) {
            formed++;
        }
        
        while ((left <= right) && (formed === required)) {
            if ((ans[0] === -1) || (right - left + 1 < ans[0])) {
                ans[0] = right - left + 1;
                ans[1] = left;
                ans[2] = right;
            }
            tempHT.set(s[left], tempHT.get(s[left]) - 1);
            if ((ht.has(s[left])) && (ht.get(s[left]) > tempHT.get(s[left]))) {
                formed--;
            }
            left++;
        }
        right++;
    }
    
    return (ans[0] === -1) ? '' : s.slice(ans[1], ans[2] + 1);
};