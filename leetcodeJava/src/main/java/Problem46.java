// 46. Permutations

class Solution {
    
    private void addSolution(int[] nums, List<List<Integer>> res) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int n : nums) {
            temp.add(n);
        }
        res.add(temp);
    }
    
    private void backtrack(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length - 1) {
            this.addSolution(nums, res);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            this.backtrack(nums, start + 1, res);
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        this.backtrack(nums, 0, res);
        return res;
    }
}