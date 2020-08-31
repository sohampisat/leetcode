// 15. 3Sum

class Solution {
    
    private void twoSum(int[] nums, int current, List<List<Integer>> res) {
        int i = current + 1, j = nums.length - 1;
        while (i < j) {
            int tempSum = nums[current] + nums[i] + nums[j];
            if (tempSum == 0) {
                List<Integer> tempList = new ArrayList<Integer>();
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
            } else if (tempSum < 0) {
                i++;
            } else {
                j--;
            }
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        } else if (nums.length == 3) {
            if(nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int n : nums) {
                    temp.add(n);
                }
                List<List<Integer>> res = new ArrayList<List<Integer>>();
                res.add(temp);
                return res;
            }
        }
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            this.twoSum(nums, i, res);
        }
        
        return res;
    }
}