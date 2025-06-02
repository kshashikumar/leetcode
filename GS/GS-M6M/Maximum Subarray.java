class Solution {
    public int maxSubArray(int[] nums) {
        int sum =0, mxSum = Integer.MIN_VALUE;

        for(int num:nums){
            sum += num;

            if(sum > mxSum){
                mxSum = sum;
            }

            if(sum <0){
                sum =0;
            }
        }
        return mxSum;
    }
}