class Solution {
    public void swap(int[] nums, int i, int j){
        int t=nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int k=0,j=1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                ans[k] = nums[i];
                k=k+2;
            } else if(nums[i]%2 > 0 ){
                System.out.println(nums[i]);
                ans[j] = nums[i];
                j = j+2;
            }
        }
        return ans;
    }
}