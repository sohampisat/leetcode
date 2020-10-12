// 217. Contains Duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> ht = new HashSet<>();
        for (int n : nums) {
            if (ht.contains(n)) {
                return true;
            }
            ht.add(n);
        }
        return false;
    }
}