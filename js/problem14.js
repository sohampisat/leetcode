/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (strs.length === 0) {
        return '';
    } else if (strs.length === 1) {
        return strs[0];
    }
    
    let i = 0;
    let flag = true;
    while (i < strs[0].length) {
        let reference = strs[0][i];
        for (let j = 1; j < strs.length; j++) {
            if (i >= strs[j].length) {
                flag = false;
                break;
            }
            
            if (strs[j][i] !== reference) {
                flag = false;
                break;
            }
        }
        
        if (!flag) {
            break;
        }
        i++;
    }
    
    return strs[0].slice(0, i);
};