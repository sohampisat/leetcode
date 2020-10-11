// 10. Regular Expression Matching

class Solution {    
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (p.charAt(0) == '*') {
            return false;
        }
        char[] inputString = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] matrix = new boolean[s.length() + 1][p.length() + 1];
        matrix[0][0] = true;
        for (int i = 1; i < matrix[0].length; i++) {
            if (pattern[i - 1] == '*') {
                matrix[0][i] = matrix[0][i - 2];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if ((inputString[i - 1] == pattern[j - 1]) || (pattern[j - 1] == '.')) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (matrix[i][j - 2]) {
                        matrix[i][j] = true;
                    } else if ((inputString[i - 1] == pattern[j - 2]) || (pattern[j - 2] == '.')) {
                        matrix[i][j] = matrix[i - 1][j];
                    }
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}