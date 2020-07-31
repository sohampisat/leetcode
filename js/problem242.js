/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    
    let arr = new Array(26);
    
    for (let i = 0; i < s.length; i++) {
        let index = s.charCodeAt(i) - 'a'.charCodeAt();
        arr[index] = (arr[index] === undefined) ? 1 : arr[index] + 1;
    }
    
    for (let i = 0; i < t.length; i++) {
        let index = t.charCodeAt(i) - 'a'.charCodeAt();
        if ((arr[index] === undefined) || (arr[index] === 0)) {
            return false;
        }
        arr[index]--;
    }
    
    return true;
};