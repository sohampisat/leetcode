// 242. Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0) {
            return t.length() == 0;
        } else if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> ht = new HashMap<>();
        for (char c : s.toCharArray()) {
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            int temp = ht.getOrDefault(c, -1);
            if (temp == -1) {
                return false;
            }
            if (temp == 1) {
                ht.remove(c);
            } else {
                ht.put(c, temp - 1);
            }
        }
        return ht.isEmpty();
    }
}