class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int ans = events[0][0];
        int mxDur = events[0][1];
        for(int i=1;i<events.length;i++){
            int diff = events[i][1] - events[i-1][1];
            if(diff == mxDur){
                 ans = (events[i][0] < ans) ? events[i][0] : ans;
            } else if(diff > mxDur){
                mxDur = diff;
                ans = events[i][0];
            }
        }
        return ans;
    }
}