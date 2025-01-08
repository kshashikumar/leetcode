class Solution {
    public boolean canJump(int[] nums) {
        int mxIdx =0;
       for(int i=0;i<nums.length;i++){
        if(i>mxIdx){
            return false;
        }
        mxIdx = Math.max(mxIdx,i+nums[i]);
       }
       if(mxIdx>=nums.length-1){
        return true;
       }
       return false;
    }
}