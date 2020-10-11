// 49. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        } else if (strs.length == 1) {
            List<String> temp = new ArrayList<>();
            temp.add(strs[0]);
            List<List<String>> res = new ArrayList<>();
            res.add(temp);
            return res;
        }
        Map<String, List<String>> ht = new HashMap<>();
        for (String s : strs) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String key = new String(tempArray);
            if (ht.containsKey(key)) {
                ht.get(key).add(s);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                ht.put(key, temp);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : ht.keySet()) {
            res.add(ht.get(key));
        }
        return res;
    }
}