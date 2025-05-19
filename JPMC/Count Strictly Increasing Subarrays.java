class Solution {
    public long countSubarrays(int[] nums) {
        long len =1, count=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                len++;
            } else {
                len =1;
            }
            count +=len;
        }

        return count+1;
    }
}