// 70. Climbing Stairs

class Solution {
    
    private int climbStairsUtil(int n, Map<Integer, Integer> ht) {
        if (ht.containsKey(n)) {
            return ht.get(n);
        }
        int res = this.climbStairsUtil(n - 1, ht) + this.climbStairsUtil(n - 2, ht);
        ht.put(n, res);
        return res;
    }
    
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        Map<Integer, Integer> ht = new HashMap<>();
        ht.put(1, 1);
        ht.put(2, 2);
        return this.climbStairsUtil(n, ht);
    }
}