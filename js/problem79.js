/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */


const searchWord = (board, word, i, j, curr) => {
    if (curr === word.length) {
        return true;
    }
    
    if ((i > 0) && (board[i - 1][j] === word[curr])) {
        let originalValue = board[i - 1][j];
        board[i - 1][j] = '-';
        let temp = searchWord(board, word, i - 1, j, curr + 1);
        if (temp) {
            return true;
        }
        board[i - 1][j] = originalValue;
    }
    
    if ((j < board[0].length - 1) && (board[i][j + 1] === word[curr])) {
        let originalValue = board[i][j + 1];
        board[i][j + 1] = '-';
        let temp = searchWord(board, word, i, j + 1, curr + 1);
        if (temp) {
            return temp;
        }
        board[i][j + 1] = originalValue;
    }
    
    if ((i < board.length - 1) && (board[i + 1][j] === word[curr])) {
        let originalValue = board[i + 1][j];
        board[i + 1][j] = '-';
        let temp = searchWord(board, word, i + 1, j, curr + 1);
        if (temp) {
            return true;
        }
        board[i + 1][j] = originalValue;
    }
    
    if ((j > 0) && (board[i][j - 1] === word[curr])) {
        let originalValue = board[i][j - 1];
        board[i][j - 1] = '-';
        let temp = searchWord(board, word, i, j - 1, curr + 1);
        if (temp) {
            return true;
        }
        board[i][j - 1] = originalValue;
    }
    
    return false;
};

var exist = function(board, word) {
    if (word.length === 0) {
        return true;
    }
    if ((board.length === 0) || (board[0].length === 0)) {
        return false;
    }
    
    for (let i = 0; i < board.length; i++) {
        for(let j = 0; j < board[0].length; j++) {
            if (board[i][j] === word[0]) {
                let originalValue = board[i][j];
                board[i][j] = '-';
                let temp = searchWord(board, word, i, j, 1);
                if (temp) {
                    return true;
                }
                board[i][j] = originalValue;
            }
        }
    }
    
    return false;
    
};