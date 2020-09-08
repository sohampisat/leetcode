// 844. Backspace String Compare

class Solution {
    
    private Stack<Character> createStringStack(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack;
    }
    
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = this.createStringStack(S);
        Stack<Character> stackT = this.createStringStack(T);
        
        return stackS.equals(stackT);
    }
}