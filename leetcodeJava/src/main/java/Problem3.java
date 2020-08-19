// 3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        
        Map<Character, Integer> ht = new HashMap<Character, Integer>();
        ht.put(s.charAt(0), 0);
        int res = 1, i = 0, j = 1;
        while (j < s.length()) {
            char currentChar = s.charAt(j);
            int temp = ht.getOrDefault(currentChar, -1);
            if (temp < i) {
                if (j - i + 1 > res) {
                    res = j - i + 1;
                }
                ht.put(currentChar, j);
                j++;
            } else {
                i = temp + 1;
                if (i == j) {
                    j++;
                    ht = new HashMap<Character, Integer>();
                    ht.put(s.charAt(i), i);
                }
            }
        }
        
        return res;
    }
}