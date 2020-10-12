// 52. N-Queens II

class Solution {
    
    private boolean canPlace(char[][] board, int row, int column) {
        for (int j = 0; j < column; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = column -1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    private int placeQueen(char[][] board, int column) {
        if (column == board.length) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            if (this.canPlace(board, i, column)) {
                board[i][column] = 'Q';
                res += this.placeQueen(board, column + 1);
                board[i][column] = '\u0000';
            }
        }
        return res;
    }
    
    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        } else if (n < 4) {
            return 0;
        }
        char[][] board = new char[n][n];
        return this.placeQueen(board, 0);
    }
}