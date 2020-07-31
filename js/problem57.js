/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    if (intervals.length === 0) {
        return [newInterval];
    }
    
    let res = [];
    for (var i = 0; i < intervals.length; i++) {
        if (intervals[i][0] >= newInterval[0]) {
            break;
        }
        res.push(intervals[i]);
    }
    let loc = i;
    i--;
    
    if ((i >= 0) && (res[i][1] >= newInterval[0])) {
        res[i][1] = Math.max(res[i][1], newInterval[1]);
    } else {
        res.push(newInterval);
        i++;
    }
    
    for (let j = loc; j < intervals.length; j++) {
        if (res[i][1] >= intervals[j][0]) {
            res[i][1] = Math.max(res[i][1], intervals[j][1]);
        } else {
            res.push(intervals[j]);
        }
    }
    
    return res;
};