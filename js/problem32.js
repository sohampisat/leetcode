/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    if (s.length <= 1) {
        return 0;
    }
    
    let stack = [-1], res = 0;
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            stack.push(i);
        } else {
            stack.pop();
            if (stack.length === 0) {
                stack.push(i);
            } else {
                let temp = (i + 1) - stack[stack.length - 1] - 1;
                if (temp > res) {
                    res = temp;
                }
            }
        }
    }
    
    return res;
    
};