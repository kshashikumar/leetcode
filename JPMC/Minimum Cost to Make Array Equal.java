class Solution {
    public long minCost(int[] nums, int[] cost) {

        int n = nums.length;
        int[][] pairs = new int[n][2];

        for(int i=0;i<n;i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = cost[i];
        }

        Arrays.sort(pairs, Comparator.comparingInt(a->a[0]));

        long totCost =0;

        for(int[] pair:pairs){
            totCost += pair[1];
        }

        long cur =0, median =0;

        for(int[] pair:pairs){
            cur+=pair[1];
            if(cur >= (totCost+1)/2){
                median = pair[0];
                break;
            }
        }
        long ans =0;
        for(int[] pair:pairs){
            ans += (long)Math.abs(pair[0] - median) * pair[1];
        }
        return ans;
    }
}