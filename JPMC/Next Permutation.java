class Solution {
    public void swap(int[] nums, int st,int ed){
        int t=nums[st];
        nums[st] = nums[ed];
        nums[ed] = t;
    }


    public void reverse(int[] nums,int st){
        int ed = nums.length-1;

        while(st<ed){
            swap(nums,st,ed);
            st++;
            ed--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length -2;

        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if(i>=0){
            int j =nums.length-1;

            while(j>=0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
}