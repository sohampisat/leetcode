// 32. Longest Valid Parentheses

class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                int temp = stack.pop();
                if (!stack.empty()) {
                    int currentMaxLength = i - stack.peek();
                    res = (currentMaxLength > res) ? currentMaxLength : res;
                } else {
                    stack.push(i);
                }
            }
        }
        
        return res;
    }
}