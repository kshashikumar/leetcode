class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0, endTime = Integer.MIN_VALUE;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for (int[] interval : intervals) {
            if (interval[0] >= endTime) {
                count++;
                endTime = interval[1];
            }
        }
        return intervals.length - count;
    }
}