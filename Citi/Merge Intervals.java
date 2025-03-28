class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(intervals.length == 0){
            return new int[n][n];
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] curr = intervals[0];
        int k=0;
        List<int[]> ans = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            int mx = Math.max(curr[0],intervals[i][0]);
            int mn = Math.min(curr[1],intervals[i][1]);
            System.out.println(mx+" "+mn);

            if(mx <= mn){
                curr[1] = Math.max(curr[1],intervals[i][1]);;
            } else {
                ans.add(curr);
                curr=intervals[i];
            }
        }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][]);
    }
}