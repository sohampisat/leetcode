// 6. ZigZag Conversion

class Solution {
    public String convert(String s, int numRows) {
        if ((numRows == 1) || (s.length() <= numRows)) {
            return s;
        }
        
        List<Character>[] matrix = new ArrayList[numRows];
        
        for (int i = 0; i < numRows; i++) {
            matrix[i] = new ArrayList<Character>();
        }
        
        int loc = 0;
        boolean direction = false;
        for (int i = 0; i < s.length(); i++) {
            matrix[loc].add(s.charAt(i));
            if ((loc == 0) || (loc == numRows - 1)) {
                direction = !direction;
            }
            if (direction == true) {
                loc++;
            } else {
                loc--;
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < matrix[i].size(); j++) {
                res.append(matrix[i].get(j));
            }
        }
        return res.toString();
    }
}