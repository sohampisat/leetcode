// 5. Longest Palindromic Substring

class Solution {
    
    private int[] expandAroundCenter(String s, int i, int j) {
        while ((i >= 0) && (j < s.length()) && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        
        return new int[] {i + 1, j - 1};
    }
    
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        int[] ans = new int[] {0, 0};
        for (int i = 0; i < s.length() - 1; i++) {
            int[] tempRes = this.expandAroundCenter(s, i, i);
            int tempSize = tempRes[1] - tempRes[0] + 1;
            if (tempSize > ans[1] - ans[0] + 1) {
                ans[0] = tempRes[0];
                ans[1] = tempRes[1];
            }
            
            if (s.charAt(i) == s.charAt(i + 1)) {
                tempRes = this.expandAroundCenter(s, i, i + 1);
                tempSize = tempRes[1] - tempRes[0] + 1;
                if (tempSize > ans[1] - ans[0] + 1) {
                    ans[0] = tempRes[0];
                    ans[1] = tempRes[1];
                }
            }
        }
        
        return s.substring(ans[0], ans[1] + 1);
    }
}