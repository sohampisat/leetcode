// 38. Count and Say

class Solution {
    
    private String buildSequence(String s) {
        if (s.length() == 0) {
            return "";
        }
        
        StringBuilder res = new StringBuilder();
        int counter = 1;
        char current = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                counter++;
            } else {
                res.append(counter);
                res.append(current);
                counter = 1;
                current = s.charAt(i);
            }
        }
        
        res.append(counter);
        res.append(current);
        
        return res.toString();
    }
    
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String previousSequence = this.countAndSay(n - 1);
        return this.buildSequence(previousSequence);
    }
}