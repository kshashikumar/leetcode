class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        int[] cur = intervals[0];
        List<int[]> ans = new ArrayList<>();

       

        for(int i=1;i<intervals.length;i++){
            int st = Math.max(cur[0],intervals[i][0]);
            int ed = Math.min(cur[1],intervals[i][1]);

            if(st<=ed){
                cur[1] = Math.max(cur[1],intervals[i][1]);
            } else {
                ans.add(cur);
                cur = intervals[i];   
            }
        }
        ans.add(cur);
        return ans.toArray(new int[ans.size()][]);

    }
}