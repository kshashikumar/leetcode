class Solution {
    public int maxArea(int[] height) {
        int l =0, r= height.length-1, mxArea=0;

        while(l<=r){
            mxArea = Math.max(mxArea, (r-l) * Math.min(height[l] , height[r]));
            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return mxArea;
    }
}