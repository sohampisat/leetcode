/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if (numRows === 0) {
        return "";
    }
    
    if ((numRows === 1) || (s.length <= numRows)) {
        return s;
    }
    
    var matrix = [];
    for (let i = 0; i < numRows; i++) {
        matrix.push([]);
    }
    
    let down = false;
    let row = 0;
    
    for (let i = 0; i < s.length; i++) {
        if ((row === 0) || (row === numRows - 1)) {
            down = !down;
        }
        
        matrix[row].push(s[i]);
        if (down) {
            row++;
        } else {
            row--;
        }
        
    }
    
    let res = '';
    
    for (let i = 0; i < numRows; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            res += matrix[i][j];
        }
    }
    
    return res;
};
