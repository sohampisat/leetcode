/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    if (digits.length === 0) {
        return [];
    }
    
    digits[digits.length - 1]++;
    if (digits[digits.length - 1] < 10) {
        return digits;
    }
    
    let carry = 1;
    digits[digits.length - 1] %= 10;
    for (let i = digits.length - 2; i >= 0 && carry === 1; i--) {
        digits[i]++;
        if (digits[i] > 9) {
            carry = 1;
            digits[i] %= 10;
        } else {
            carry = 0;
            break;
        }
    }
    
    if (carry) {
        digits.unshift(1);
    }
    
    return digits;
    
};