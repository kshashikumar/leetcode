class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);

        int[] curr = intervals[0];

        for(int i=1;i<intervals.length;i++){

            int rightEnds = Math.min(curr[1],intervals[i][1]);
            int leftEnds = Math.max(curr[0],intervals[i][0]);

            if(rightEnds >= leftEnds){
                curr[1] = Math.max(intervals[i][1],curr[1]);
            } else {
                ans.add(curr);
                curr = intervals[i];
            }

        }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][]);
    }
}