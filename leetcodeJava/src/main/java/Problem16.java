// 16. 3Sum Closest

class Solution {
    
    private int twoSum(int[] nums, int target, int current) {
        int i = current + 1, j = nums.length - 1;
        int res = nums[current] + nums[i] + nums[j];
        while (i < j) {
            int tempSum = nums[current] + nums[i] + nums[j];
            if (tempSum == target) {
                return target;
            } else if (tempSum < target) {
                i++;
            } else {
                j--;
            }
            
            if ((Math.abs(target - tempSum)) < (Math.abs(target - res))) {
                res = tempSum;
            }
        }
        
        return res;
    }
    
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        if (res == target) {
            return target;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            
            int temp = this.twoSum(nums, target, i);
            if (temp == target) {
                return target;
            }
            if (Math.abs(target - temp) < Math.abs(target - res)) {
                res = temp;
            }
        }
        
        return res;
    }
}