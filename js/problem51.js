/**
 * @param {number} n
 * @return {string[][]}
 */


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
    
    for (let i = row + 1, j = col - 1; (i < n) && (col >= 0); i++, j--) {
        if (board[i][j] === 'Q') {
            return false;
        }
    }
    
    return true;
};

const addSolution = function(n, board, res) {
    let tempBoard = [];
    for (let i = 0; i < n; i++) {
        let s = '';
        for (let j = 0; j < n; j++) {
            s += board[i][j];
        }
        tempBoard.push(s);
    }
    
    res.push(tempBoard);
};

const placeQueen = function(n, board, col, res) {
    if (col === n) {
        addSolution(n, board, res);
        return;
    }
    
    for (let row = 0; row < n; row++) {
        if (canPlace(n, board, row, col)) {
            board[row][col] = 'Q';
            placeQueen(n, board, col + 1, res);
            board[row][col] = '.';
        }
    }
};

var solveNQueens = function(n) {
    if (n === 0) {
        return [];
    } else if (n === 1) {
        return [['Q']];
    }
    
    let res = [];
    
    let board = initializeBoard(n);
   
    placeQueen(n, board, 0, res);
    
    return res;
};