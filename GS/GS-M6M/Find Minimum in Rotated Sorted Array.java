class Solution {
    public int findMin(int[] nums) {
        int l=0, r = nums.length-1,minV = Integer.MAX_VALUE;

        while(l<=r){
            int  m  = l +(r-l)/2;

            if(nums[l] <= nums[m]){
                minV = Math.min(minV, nums[l]);
                l = m+1;
            } else {
                minV = Math.min(minV,nums[m]);
                r = m-1;
            }
        }
        return minV;
    }
}