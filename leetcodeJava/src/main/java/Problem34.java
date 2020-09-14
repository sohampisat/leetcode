// 34. Find First and Last Position of Element in Sorted Array

class Solution {
    
    private int[] binaryPositionSearch(int[] nums, int target, int start, int end) {
        int length = end - start + 1;
        if (length == 0) {
            return new int[] {-1, -1};
        } else if (length == 1) {
            if (nums[start] == target) {
                return new int[] {start, start};
            }
            return new int[] {-1, -1};
        } else if (length == 2) {
            if (nums[start] == target && nums[end] == target) {
                return new int[] {start, end};
            } else if (nums[start] == target) {
                return new int[] {start, start};
            } else if (nums[end] == target) {
                return new int[] {end, end};
            }
            return new int[] {-1, -1};
        }
        
        int mid = (start + end) / 2;
        
        if (nums[mid] == target) {
            int[] res = new int[] {mid, mid};
            if (nums[mid - 1] == target) {
                res[0] = this.binaryPositionSearch(nums, target, start, mid - 1)[0];
            }
            if (nums[mid + 1] == target) {
                res[1] = this.binaryPositionSearch(nums, target, mid + 1, end)[1];
            }
            return res;
        } else if (target < nums[mid]) {
            return this.binaryPositionSearch(nums, target, start, mid - 1);
        }
        
        return this.binaryPositionSearch(nums, target, mid + 1, end);
    }
    
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        } else if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] {0, 0};
            }
            return new int[] {-1, -1};
        }
        
        return this.binaryPositionSearch(nums, target, 0, nums.length - 1);
        
    }
}