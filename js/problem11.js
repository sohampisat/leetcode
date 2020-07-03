/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    if (height.length === 2) {
        return (height[0] <= height[1]) ? height[0] : height[1];
    }
    
    let res = 0;
    let i = 0, j = height.length - 1;
    
    while (i < j) {
        let currentVolume = Math.min(height[i], height[j]) * (j - i);
        if (currentVolume > res) {
            res = currentVolume;
        }
        
        if (height[i] < height[j]) {
            i++;
        } else if (height[i] > height[j]) {
            j--;
        } else {
            if (height[i + 1] >= height[j - 1]) {
                i++;
            } else {
                j--;
            }
        }
    }
    
    return res;
};