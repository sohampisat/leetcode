// 20. Valid Parentheses

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        } else if (s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else {
                if (current == ')') {
                    if (stack.empty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                } else if (current == '}') {
                    if (stack.empty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                } else {
                    if (stack.empty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        
        return stack.empty();
    }
}