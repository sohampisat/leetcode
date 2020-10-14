// 56. Merge Intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<Pair<Integer, Integer>> nums = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            nums.add(new Pair<>(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(nums, new Comparator<Pair<Integer, Integer>>() {
            @Override public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                return a.getKey() - b.getKey();
            }
        });
        while (nums.size() > 1) {
            List<Pair<Integer, Integer>> temp = new ArrayList<>();
            temp.add(nums.get(0));
            int i = 1;
            int j = 0;
            while (i < nums.size()) {
                if (temp.get(j).getValue() >= nums.get(i).getKey()) {
                    if (temp.get(j).getValue() < nums.get(i).getValue()) {
                        temp.set(j, new Pair<>(temp.get(j).getKey(), nums.get(i).getValue()));
                    }
                } else {
                    temp.add(nums.get(i));
                    j++;
                }
                i++;
            }
            if (nums.size() == temp.size()) {
                break;
            }
            nums = temp;
        }
        int[][] res = new int[nums.size()][2];
        for (int i = 0; i < nums.size(); i++) {
            res[i][0] = nums.get(i).getKey();
            res[i][1] = nums.get(i).getValue();
        }
        return res;
    }
}