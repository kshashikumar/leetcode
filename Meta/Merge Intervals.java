public class Merge Intervals
{
    
    // In this,we will check if the curr interval end is overlapping or not and will update curr Interval end, when we encounter non-overlapping, we store curr and then update curr.
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] curr = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                ans.add(curr);
                curr = intervals[i];
            }
        }
        ans.add(curr);

        return ans.toArray(new int[ans.size()][]);
    }
}
