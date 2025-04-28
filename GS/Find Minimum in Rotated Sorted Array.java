public class Find Minimum in Rotated Sorted Array {
    public int findMin(int[] nums) {
        int l=0,r = nums.length-1,mi=Integer.MAX_VALUE;

        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[l] <= nums[m]){
                mi = Math.min(nums[l],mi);
                l = m+1;
            } else {
                mi = Math.min(nums[m],mi);
                r = m-1;
            }
        }
        return mi;
    }
}
