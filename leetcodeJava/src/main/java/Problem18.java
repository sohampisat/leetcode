// 18. 4Sum

class Solution {
    
    private void twoSum(int[] nums, int current, int previousSum, List<List<Integer>> res, int target) {
        int i = current + 1, j = nums.length - 1;
        while (i < j) {
            int tempSum = previousSum + nums[current] + nums[i] + nums[j];
            if (tempSum == target) {
                List<Integer> tempList = new ArrayList<Integer>();
                tempList.add(previousSum);
                tempList.add(nums[current]);
                tempList.add(nums[i]);
                tempList.add(nums[j]);
                res.add(tempList);
                i++;
                while ((i < j) && (nums[i] == nums[i - 1])) {
                    i++;
                }
                j--;
                while ((i < j) && (nums[j] == nums[j + 1])) {
                    j--;
                }
            } else if (tempSum < target) {
                i++;
            } else {
                j--;
            }
        }
    }
    
    private void threeSum(int[] nums, int current, List<List<Integer>> res, int target) {
        for (int i = current + 1; i < nums.length - 2; i++) {
            if ((i > current + 1) && (nums[i] == nums[i - 1])) {
                continue;
            }
            
            this.twoSum(nums, i, nums[current], res, target);
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            
            this.threeSum(nums, i, res, target);
        }
        
        return res;
    }
}