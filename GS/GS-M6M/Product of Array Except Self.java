class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n+2];
        int[] suffix = new int[n+2];
        Arrays.fill(prefix,1);
        Arrays.fill(suffix,1);

        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i=n;i>0;i--){
            suffix[i] = suffix[i+1] * nums[i-1];
        }

        for(int i=1;i<=n;i++){
            ans[i-1] = prefix[i - 1] * suffix[i+1];
        }
        return ans;
    }
}