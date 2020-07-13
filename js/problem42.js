/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height.length < 3) {
        return 0;
    }
    
    let leftMax = new Array(height.length), rightMax = new Array(height.length);
    
    leftMax[0] = height[0];
    rightMax[rightMax.length - 1] = height[height.length - 1];
    
    for (let i = 1; i < height.length; i++) {
        leftMax[i] = (height[i] > leftMax[i - 1]) ? height[i] : leftMax[i - 1];
    }
    
    for (let i = height.length - 2; i >= 0; i--) {
        rightMax[i] = (height[i] > rightMax[i + 1]) ? height[i] : rightMax[i + 1];
    }

    let res = 0;
    
    for (let i = 1; i < height.length - 1; i++) {
        res += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    
    return res;
};