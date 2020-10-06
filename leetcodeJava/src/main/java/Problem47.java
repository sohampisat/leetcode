// 47. Permutations II

class Solution {
    
    private void backtrack(int arraySize, Map<Integer, Integer> ht, LinkedList<Integer> current, List<List<Integer>> res) {
        if (current.size() == arraySize) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int key : ht.keySet()) {
            int value = ht.get(key);
            if (value == 0) {
                continue;
            }
            ht.put(key, value - 1);
            current.addLast(key);
            this.backtrack(arraySize, ht, current, res);
            current.removeLast();
            ht.put(key, ht.get(key) + 1);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> ht = new HashMap<>();
        LinkedList<Integer> current = new LinkedList<>();
        for (int n : nums) {
            ht.put(n, ht.getOrDefault(n, 0) + 1);
        }
        this.backtrack(nums.length, ht, current, res);
        return res;
    }
}