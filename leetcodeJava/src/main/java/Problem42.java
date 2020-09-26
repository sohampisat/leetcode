// 42. Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        
        maxLeft[0] = height[0];
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = (height[i] > maxLeft[i - 1]) ? height[i] : maxLeft[i - 1];
        }
        
        maxRight[maxRight.length - 1] = height[height.length - 1];
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = (height[i] > maxRight[i + 1]) ? height[i] : maxRight[i + 1];
        }
        
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int volumeAtCurrent = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (volumeAtCurrent > 0) {
                res += volumeAtCurrent;
            }
        }
        
        return res;
    }
}