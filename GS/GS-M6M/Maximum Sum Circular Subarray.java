class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int tot =0;
        int curMax =0, maxSum = nums[0];
        int curMin =0, minSum = nums[0];

        for(int num:nums){
            tot+=num;

            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
        }

        if(maxSum<0) return maxSum;

        return Math.max(maxSum, tot - minSum);

    }
}