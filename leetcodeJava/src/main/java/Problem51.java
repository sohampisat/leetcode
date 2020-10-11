// 51. N-Queens

class Solution {
    
    private boolean canPlace(char[][] board, int row, int column) {
        for (int j = 0; j < column; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = column - 1; (i >= 0) && (j >= 0); i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row + 1, j = column - 1; (i < board.length) && (j >= 0); i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    private void addSolution(char[][] board, List<List<String>> res) {
        List<String> newSolution = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            newSolution.add(new String(board[row]));
        }
        res.add(newSolution);
    }
    
    private void placeQueen(char[][] board, int column, List<List<String>> res) {
        if (column == board.length) {
            this.addSolution(board, res);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (this.canPlace(board, i, column)) {
                board[i][column] = 'Q';
                this.placeQueen(board, column + 1, res);
                board[i][column] = '.';
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            List<String> temp = new ArrayList<>();
            temp.add(new String("Q"));
            List<List<String>> res = new ArrayList<>();
            res.add(temp);
            return res;
        } else if (n < 4) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            Arrays.fill(board[row], '.');
        }
        this.placeQueen(board, 0, res);
        return res;
    }
}