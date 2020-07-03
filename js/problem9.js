/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if (x < 0) {
        return false;
    } else if (x < 10) {
        return true;
    } else if (x % 10 === 0) {
        return false;
    }
    
    let y = 0;
    
    while (x > y) {
        let temp = x % 10;
        x = Math.floor(x / 10);
        if (x === y) {
            return true;
        }
        y = (y * 10) + temp;
        if (x === y) {
            return true;
        }
    }
    
    return false;
};