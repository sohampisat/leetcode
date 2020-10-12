// 387. First Unique Character in a String

class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        } else if (s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (ht.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}