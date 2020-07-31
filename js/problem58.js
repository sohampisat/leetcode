/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    s = s.trim();
    if (s.length === 0) {
        return 0;
    }
    let charArr = s.split(' ');
    return charArr[charArr.length - 1].length;
};