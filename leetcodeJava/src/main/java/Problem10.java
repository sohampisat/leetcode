// 10. Regular Expression Matching

class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] matrix = new boolean[text.length + 1][pattern.length + 1];
        matrix[0][0] = true;
        
        for (int j = 1; j < matrix[0].length; j++) {
            if (pattern[j - 1] == '*') {
                matrix[0][j] = matrix[0][j - 2];
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if ((text[i- 1] == pattern[j - 1]) || (pattern[j - 1] == '.')) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    matrix[i][j] = matrix[i][j - 2] || ((pattern[j - 2] == text[i - 1] || pattern[j - 2] == '.') && (matrix[i - 1][j]));
                } else {
                    matrix[i][j] = false;
                }
            }
        }
        
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}