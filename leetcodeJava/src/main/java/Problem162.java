// 162. Find Peak Element

class Solution {
    
    private int binarySearch(int[] nums, int start, int end) {
        int length = end - start + 1;
        if (length == 1) {
            return start;
        } else if (length == 2) {
            return (nums[start] > nums[end]) ? start : end;
        }
        
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        
        if (nums[mid] < nums[mid + 1]) {
            return this.binarySearch(nums, mid + 1, end);
        }
        
        return this.binarySearch(nums, start, mid);
    }
    
    public int findPeakElement(int[] nums) {
        return this.binarySearch(nums, 0, nums.length - 1);
    }
}