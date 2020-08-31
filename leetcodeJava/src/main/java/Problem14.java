// 14. Longest Common Prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        
        int res = 0;
        
        while (res < strs[0].length()) {
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if ((res >= strs[i].length()) || (strs[0].charAt(res) != strs[i].charAt(res))) {
                    flag = false;
                    break;
                }
            }
            
            if (!flag) {
                break;
            }
            res++;
        }
        
        return strs[0].substring(0, res);
    }
}