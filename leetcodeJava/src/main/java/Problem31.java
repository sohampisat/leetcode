// 31. Next Permutation

class Solution {
    
    private int getSwapIndex(int[] nums, int lowerIndex) {
        int res = lowerIndex + 1;
        for (int i = lowerIndex + 2; i < nums.length; i++) {
            if ((nums[i] > nums[lowerIndex]) && (nums[i] <= nums[res])) {
                res = i;
            }
        }
        
        return res;
    }
    
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        
        if (nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        
        int lowerIndex = nums.length - 2;
        while (lowerIndex >= 0) {
            if (nums[lowerIndex] < nums[lowerIndex + 1]) {
                break;
            }
            lowerIndex--;
        } 
        
        if (lowerIndex != -1) {
            int swapIndex = this.getSwapIndex(nums, lowerIndex);
            int temp = nums[lowerIndex];
            nums[lowerIndex] = nums[swapIndex];
            nums[swapIndex] = temp;
        }
        
        int i = lowerIndex + 1;
        int j = nums.length - 1;
        
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}