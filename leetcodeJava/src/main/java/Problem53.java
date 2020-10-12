// 53. Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } 
        int tempMax = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempMax = (tempMax + nums[i] > nums[i]) ? tempMax + nums[i]: nums[i];
            res = (tempMax > res) ? tempMax : res;
        }
        return res;
    }
}