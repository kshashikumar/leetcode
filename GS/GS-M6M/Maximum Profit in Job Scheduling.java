class Job{
    int start;
    int end;
    int profit;

    Job(int s, int e, int p){
        this.start = s;
        this.end = e;
        this.profit = p;
    }
}

class Solution {

    public int binarySearch(Job[] jobs,int index){
        int low =0, high = index-1;

        while(low<= high){
            int mid = low + (high - low)/2;

            if(jobs[mid].end <= jobs[index].start){
                if(jobs[mid+1].end <= jobs[index].start){
                    low = mid+1;
                } else {
                    return mid;
                }
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }

        Arrays.sort(jobs,Comparator.comparingInt( a -> a.end));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for(int i=1;i<n;i++){
            int include = jobs[i].profit;
            int l = binarySearch(jobs,i);

            if(l != -1){
                include += dp[l];
            }

            dp[i] = Math.max(dp[i-1],include);
        }

        return dp[n-1];
    }
}