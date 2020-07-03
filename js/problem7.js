/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    if ((x > -10) && (x < 10)) {
        return x;
    }
    
    let sign = 1;
    if (x < 0) {
        sign = -1;
    }
    
    x = Math.abs(x);
    
    let res = 0;
    
    while (x > 0) {
        let temp = x % 10;
        res = (res * 10) + temp;
        x = Math.floor(x / 10);
    }
    
    res *= sign;
    
    if ((res < -Math.pow(2, 31)) || (res > (Math.pow(2, 31) - 1))) {
        return 0;
    }
    
    return res;
};