package GS;

public class Trapping Rain Water {
    
        public int trap(int[] height) {
            int n= height.length;
            int[] pMax = new int[n];
            pMax[0] = height[0];
            for(int i=1;i<n;i++){
                pMax[i] = Math.max(pMax[i-1],height[i]);
            }
            int[] sMax = new int[n];
            sMax[n-1] = height[n-1];
            for(int i=n-2;i>=0;i--){
                sMax[i] = Math.max(sMax[i+1],height[i]);
            }
            int ans=0;
            for(int i=0;i<n;i++){
                if(height[i]<pMax[i] && height[i]<sMax[i]){
                    ans+=Math.min(pMax[i],sMax[i]) - height[i];
                }
            }
            return ans;
        }
        public int trap(int[] height) {
            int n=height.length;
            int ans=0,lMax=height[0],rMax=height[n-1],l=0,r=n-1;
            while(l<r){
                if(height[l] <= height[r]){
                    lMax = Math.max(lMax,height[l]);
                    if(height[l]<lMax){
                        ans+= lMax - height[l]; 
                    }
                    l++;
                } else {
                    rMax = Math.max(rMax,height[r]);
                    if(height[r]<rMax){
                        ans+=rMax-height[r];
                    }
                    r--;
                }
            }
            return ans;
        }
}
