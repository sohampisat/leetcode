// 30. Substring with Concatenation of All Words

class Solution {
    
    private Map<String, Integer> generateMapCopy(Map<String, Integer> ht) {
        Map<String, Integer> res = new HashMap<String, Integer>();
        for (String s : ht.keySet()) {
            res.put(s, ht.get(s));
        }
        return res;
    }
    
    private boolean containsAllWords(String s, String[] words, int start, Map<String, Integer> ht) {
        int windowLength = words.length * words[0].length();
        
        for (int i = start; i < start + windowLength; i = i + words[0].length()) {
            String word = s.substring(i, i + words[0].length());
            int temp = ht.getOrDefault(word, -1);
            if (temp == -1) {
                return false;
            } else if (temp == 1) {
                ht.remove(word);
            } else {
                ht.put(word, temp - 1);
            }
        }
        
        return true;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<Integer>();
        }
        
        Map<String, Integer> ht = new HashMap<String, Integer>();
        for (String word : words) {
            ht.put(word, ht.getOrDefault(word, 0) + 1);
        }
        
        int windowLength = words.length * words[0].length();
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length() - (windowLength - 1); i++) {
            Map<String, Integer> tempHT = this.generateMapCopy(ht);
            if (this.containsAllWords(s, words, i, tempHT)) {
                res.add(i);
            }
        }
        
        return res;
    }
}