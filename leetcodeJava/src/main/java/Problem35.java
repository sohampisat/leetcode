// 35. Search Insert Position

class Solution {
    
    private int binarySearchInsert(int[] nums, int target, int start, int end) {
        int length = end - start + 1;
        if (length == 1) {
            if (target <= nums[start]) {
                return start;
            }
            return start + 1;
        } else if (length == 2) {
            if (target <= nums[start]) {
                return start;
            } else if (target <= nums[end]) {
                return end;
            }
            return end + 1;
        }
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return this.binarySearchInsert(nums, target, start, mid - 1);
        } else {
            return this.binarySearchInsert(nums, target, mid + 1, end);
        }
    }
    
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        
        return this.binarySearchInsert(nums, target, 0, nums.length - 1);
    }
}