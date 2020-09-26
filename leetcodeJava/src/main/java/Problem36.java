// 36. Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSets = new Set[9];
        Set<Character>[] columnSets = new Set[9];
        Set<Character>[] boxSets = new Set[9];
        
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<Character>();
            columnSets[i] = new HashSet<Character>();
            boxSets[i] = new HashSet<Character>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                int box = ((i / 3) * 3) + (j / 3);
                
                if (rowSets[i].contains(board[i][j]) || columnSets[j].contains(board[i][j]) || boxSets[box].contains(board[i][j])) {
                    return false;
                }
                
                rowSets[i].add(board[i][j]);
                columnSets[j].add(board[i][j]);
                boxSets[box].add(board[i][j]);
            }
        }
        
        return true;
    }
}