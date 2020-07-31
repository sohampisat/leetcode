/**
 * @param {number} n
 * @return {number}
 */

let res = 0;

const initializeBoard = function(n) {
    let board = [];
    let row = [];
    
    for (let i = 0; i < n; i++) {
        row.push('.');
    }
    
    for (let i = 0; i < n; i++) {
        board.push(row.slice());
    }
    
    return board;
};


const canPlace = function(n, board, row, col) {
    for (let i = 0; i < col; i++) {
        if (board[row][i] === 'Q') {
            return false;
        }
    }
    
    for (let i = row - 1, j = col - 1; (i >= 0) && (j >= 0); i--, j--) {
        if (board[i][j] === 'Q') {
            return false;
        }
    }
    
    for (let i = row + 1, j = col - 1; (i < n) && (j >= 0); i++, j--) {
        if (board[i][j] === 'Q') {
            return false;
        } 
    }
    
    return true;
};

const placeQueen = function(n, board, col) {    
    if (col === n) {
        res++;
        return;
    }
    
    for (let row = 0; row < n; row++) {
        if (canPlace(n, board, row, col)) {
            board[row][col] = 'Q';
            placeQueen(n, board, col + 1);
            board[row][col] = '.';
        }
    }
};

var totalNQueens = function(n) {
    if (n === 1) {
        return 1;
    } else if (n <= 2) {
        return 0;
    }
    
    res = 0;
    
    let board = initializeBoard(n);
    placeQueen(n, board, 0);
    
    return res;
    
}