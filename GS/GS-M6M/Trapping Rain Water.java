class Solution {
    public int trap(int[] height) {
        int ans =0, l=0,r = height.length-1;
        int lMax =0,rMax =0;
        while(l<=r){
            if(height[l] <= height[r]){
                lMax = Math.max(lMax,height[l]);
                if(height[l] <lMax){
                    ans += lMax - height[l];
                }
                l++;
            } else {
                rMax = Math.max(rMax,height[r]);
                if(height[r] < rMax){
                    ans += rMax - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}