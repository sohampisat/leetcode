// 58. Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] words = s.split(" ");
        int res = 0;
        return words[words.length - 1].length();
    }
}