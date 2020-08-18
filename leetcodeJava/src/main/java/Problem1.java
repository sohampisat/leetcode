// 1. Two Sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
        ht.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int diff = target - nums[i];
            if (ht.containsKey(diff)) {
                return new int[] {ht.get(diff), i};
            }
            ht.put(nums[i], i);
        }
        return new int[0];
    }
}