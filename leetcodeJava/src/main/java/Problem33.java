// 33. Search in Rotated Sorted Array

class Solution {
    
    private int binarySearch(int[] nums, int target, int start, int end) {
        int length = end - start + 1;
        if (length == 1) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        } else if (length == 2) {
            if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            }
            return -1;
        }
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        
        if (target < nums[mid]) {
            return this.binarySearch(nums, target, start, mid - 1);
        }
        
        return this.binarySearch(nums, target, mid + 1, end);
    }    
    
    private int modifiedBinarySearch(int[] nums, int target, int start, int end) {
        
        if (nums[start] == target) {
            return start;
        }
        
        if (end - start + 1 == 1) {
            return -1;
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        if (end - start + 1 == 2) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid - 1] == target) {
            return mid - 1;
        } else if (nums[mid + 1] == target) {
            return mid + 1;
        }
        
        if (target < nums[mid]) {
            if ((nums[start] < nums[mid]) && (target > nums[start])) {
                return this.binarySearch(nums, target, start, mid - 1);
            } else if (target < nums[start] && (nums[start] < nums[mid - 1])) {
                return this.modifiedBinarySearch(nums, target, mid, end);
            }
            return this.modifiedBinarySearch(nums, target, start, mid);
        }
        
        if ((target < nums[end]) && (nums[mid] < nums[end])) {
            return this.binarySearch(nums, target, mid + 1, end);
        } else if (nums[mid + 1] < target && nums[mid + 1] < nums[end]) {
            return this.modifiedBinarySearch(nums, target, start, mid);
        }
        return this.modifiedBinarySearch(nums, target, mid, end);
        
    }
    
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } 
        
        return this.modifiedBinarySearch(nums, target, 0, nums.length - 1);
    }
}