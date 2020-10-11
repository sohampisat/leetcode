// 44. Wildcard Matching

class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean[][] matrix = new boolean[s.length() + 1][p.length() + 1];
        matrix[0][0] = true;
        char[] inputString = s.toCharArray();
        char[] pattern = p.toCharArray();
        for (int column = 1; column < matrix[0].length; column++) {
            if (pattern[column - 1] == '*') {
                matrix[0][column] = matrix[0][column - 1];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if ((inputString[i - 1] == pattern[j - 1]) || (pattern[j - 1] == '?')) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    matrix[i][j] = matrix[i][j - 1] || matrix[i - 1][j];
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}