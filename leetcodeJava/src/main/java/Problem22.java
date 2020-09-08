// 22. Generate Parentheses

class Solution {
    
    private void backtrack(int n, List<String> res, String current, int open, int close) {
        if (current.length() == n * 2) {
            res.add(current);
            return;
        }
        
        if (open < n) {
            this.backtrack(n, res, current + "(", open + 1, close);
        }
        
        if (close < open) {
            this.backtrack(n, res, current + ")", open, close + 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        this.backtrack(n, res, "", 0, 0);
        return res;
    }
}