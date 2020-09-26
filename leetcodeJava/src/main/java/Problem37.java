// 37. Sudoku Solver

class Solution {
    
    private int filled;
    
    public Solution() {
        this.filled = 0;
    }
    
    private boolean canPlace(char[][] board, int row, int column, char value) {
        for (int i = 0; i < 9; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][column] == value) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (i == column) {
                continue;
            }
            if (board[row][i] == value) {
                return false;
            }
        }
        
        int box = ((row / 3) * 3) + (column / 3);
        int[] boxLimits = new int[4];
        
        if (box < 3) {
            boxLimits[0] = 0;
            boxLimits[1] = 2;
        } else if (box < 6) {
            boxLimits[0] = 3;
            boxLimits[1] = 5;
        } else {
            boxLimits[0] = 6;
            boxLimits[1] = 8;
        }
        
        if (box % 3 == 0) {
            boxLimits[2] = 0;
            boxLimits[3] = 2;
        } else if (box % 3 == 1) {
            boxLimits[2] = 3;
            boxLimits[3] = 5;
        } else {
            boxLimits[2] = 6;
            boxLimits[3] = 8;
        }
        
        for (int i = boxLimits[0]; i<= boxLimits[1]; i++) {
            for (int j = boxLimits[2]; j <= boxLimits[3]; j++) {
                if ((i == row) && (j == column)) {
                    continue;
                }
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void solve(char[][] board, int row, int column) {
        while (board[row][column] != '.') {
            column++;
            if (column == 9) {
                row++;
                column = 0;
            }
        }
        
        for (int i = 1; i <= 9; i++) {
            if (this.canPlace(board, row, column, (char) (i + '0'))) {
                board[row][column] = (char) (i + '0');
                this.filled++;
                if (this.filled == 81) {
                    return;
                }
                this.solve(board, row, column);
                if (this.filled == 81) {
                    return;
                }
                this.filled--;
                board[row][column] = '.';
            }
        }
    }
    
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    this.filled++;
                }
            }
        }
        
        this.solve(board, 0, 0);
    }
}