class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxV=0,l=0,r=height.size()-1;
        while(l<r){
            int t = min(height[l],height[r]);
            if(maxV<(t*abs(r-l))){
                maxV = (t*abs(r-l));
            } 
            if(height[l]<=height[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxV;
    }
};