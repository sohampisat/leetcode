// 40. Combination Sum II

class Solution {
    
    private void backtrack(int[] candidates, int target, int current, int currSum, Stack<Integer> stack, List<List<Integer>> res) {
        if (currSum >= target) {
            if (currSum == target) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int num : stack) {
                    temp.add(num);
                }
                res.add(temp);
            }
            return;
        }
        
        for (int i = current + 1; i < candidates.length; i++) {
            if ((i > current + 1) && (candidates[i] == candidates[i - 1])) {
                continue;
            }
            stack.push(candidates[i]);
            this.backtrack(candidates, target, i, currSum + candidates[i], stack, res);
            stack.pop();
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < candidates.length; i++) {
            if ((i > 0) && (candidates[i] == candidates[i - 1])) {
                continue;
            }
            stack.push(candidates[i]);
            this.backtrack(candidates, target, i, candidates[i], stack, res);
            stack.pop();
        }
        
        return res;
    }
}