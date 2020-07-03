/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (s.length % 2 === 1) {
        return false;
    }
    
    let stack = [];
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            stack.push('(');
        } else if (s[i] === '{') {
            stack.push('{');
        } else if (s[i] === '[') {
            stack.push('[');
        } else if (s[i] === ')') {
            if ((stack.length === 0) || (stack[stack.length - 1] !== '(')) {
                return false;
            } else {
                stack.pop();
            }
        } else if (s[i] === '}') {
            if ((stack.length === 0) || (stack[stack.length - 1] !== '{')) {
                return false;
            } else {
                stack.pop();
            }
        } else if (s[i] === ']') {
            if ((stack.length === 0) || (stack[stack.length - 1] !== '[')) {
                return false;
            } else {
                stack.pop();
            }
        }
    }
    
    return stack.length === 0;
};