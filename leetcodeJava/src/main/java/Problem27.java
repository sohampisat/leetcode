// 27. Remove Element

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        
        int i = 0;
        int j = nums.length - 1;
        
        while (i < j) {
            if (nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            } else {
                i++;
            }
        }
        
        if (nums[i] == val) {
            return i;
        }
        
        return i + 1;
    }
}