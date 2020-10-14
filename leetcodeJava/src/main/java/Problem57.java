// 57. Insert Interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int insertPosition = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0]) {
                insertPosition = i;
                break;
            }
        }
        List<Pair<Integer, Integer>> nums = new ArrayList<>();
        for (int i = 0; i < insertPosition; i++) {
            nums.add(new Pair<>(intervals[i][0], intervals[i][1]));
        }
        if ((insertPosition > 0) && (nums.get(insertPosition - 1).getValue() >= newInterval[0])) {
            Pair<Integer, Integer> temp = new Pair<>(nums.get(insertPosition - 1).getKey(), Math.max(nums.get(insertPosition - 1).getValue(), newInterval[1]));
            nums.set(insertPosition - 1, temp);
        } else {
            nums.add(new Pair<>(newInterval[0], newInterval[1]));
        }
        int j = nums.size() - 1;
        for (int i = insertPosition; i < intervals.length; i++) {
            if (nums.get(j).getValue() >= intervals[i][0]) {
                Pair<Integer, Integer> temp = new Pair<>(nums.get(j).getKey(), Math.max(nums.get(j).getValue(), intervals[i][1]));
                nums.set(j , temp);
            } else {
                nums.add(new Pair<>(intervals[i][0], intervals[i][1]));
                j++;
            }
        }
        int[][] res = new int[nums.size()][2];
        for (int i = 0; i < nums.size(); i++) {
            res[i][0] = nums.get(i).getKey();
            res[i][1] = nums.get(i).getValue();
        }
        return res;
    }
}