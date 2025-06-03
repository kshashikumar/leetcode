class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct =1, rightProduct =1;
        int mxProduct = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            if(leftProduct == 0) leftProduct = 1;
            if(rightProduct == 0) rightProduct = 1;
            
            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];

            mxProduct = Math.max(mxProduct, Math.max(leftProduct, rightProduct));
        }

        return mxProduct;

    }
}