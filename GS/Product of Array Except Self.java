public class Product of Array Except Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n+2];
        int[] sufsum = new int[n+2];
        Arrays.fill(presum,1);
        Arrays.fill(sufsum,1);

        for(int i=1;i<=n;i++){
            presum[i] = nums[i-1] * presum[i-1]; 
        }
        for(int i=n;i>0;i--){
            sufsum[i] = nums[i-1] * sufsum[i+1]; 
        }

        int[] ans = new int[n];

        for(int i=1;i<=nums.length;i++){
            ans[i-1] = presum[i-1] * sufsum[i+1];
        }

        return ans;
    }
}
