/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    if (intervals.length < 2) {
        return intervals;
    }
    
    intervals.sort(function(a, b) {
        if (a[0] === b[0]) {
            if (a[1] === b[1]) {
                return 0;
            }
            return (a[1] < b[1]) ? -1 : 1;
        }
        return (a[0] < b[0]) ? -1 : 1;
    });
    
    let res = [intervals[0]], i = 0;
    
    for (let j = 1; j < intervals.length; j++) {
        if (res[i][1] >= intervals[j][0]) {
            res[i][1] = Math.max(res[i][1], intervals[j][1]);
        } else {
            res.push(intervals[j]);
            i++;
        }
    }
    
    return res;
};