// 55. Jump Game

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        
        int maxIndex = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }
        
        return false;
    }
}