// 41. First Missing Positive

class Solution {
    
    private boolean containsOne(int[] nums) {
        for (int n : nums) {
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] != 1) {
                return 1;
            }
            return 2;
        }
        
        if (!this.containsOne(nums)) {
            return 1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                nums[i] = 1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (current > nums.length || current == 1) {
                continue;
            } else if (current == nums.length) {
                if (nums[0] > 0) {
                    nums[0] *= -1;
                }
            } else {
                if (nums[current] > 0) {
                    nums[current] *= -1;
                }
            }
        }
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        
        if (nums[0] > 0) {
            return nums.length;
        }
        return nums.length + 1;
    }
}