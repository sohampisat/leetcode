// 45. Jump Game II

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jumps = 1;
        int maxPosition = nums[0];
        int tempMaxPosition = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPosition) {
                jumps++;
                maxPosition = tempMaxPosition;
            }
            tempMaxPosition = Math.max(tempMaxPosition, nums[i] + i);
        }
        return jumps;
    }
}