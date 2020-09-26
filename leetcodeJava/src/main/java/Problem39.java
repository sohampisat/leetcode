// 39. Combination Sum

class Solution {
    
    private void backtrack(int[] candidates, int target, int current, int currentSum, Stack<Integer> stack, List<List<Integer>> res) {
        
        if (currentSum >= target) {
            if (currentSum == target) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int n : stack) {
                    temp.add(n);
                }
                res.add(temp);
            }
            return;
        }
        
        for (int i = current; i < candidates.length; i++) {
            stack.push(candidates[i]);
            this.backtrack(candidates, target, i, currentSum + candidates[i], stack, res);
            stack.pop();
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < candidates.length; i++) {
            stack.push(candidates[i]);
            this.backtrack(candidates, target, i, candidates[i], stack, res);
            stack.pop();
        }
        
        return res;
    }
}