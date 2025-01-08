class Solution {
public:
    int maxSubArray(vector<int>& nums) {
       int mx=INT_MIN,s=0;
       for(int i=0;i<nums.size();i++){
            s=s+nums[i];
            if(s>mx){
                mx=s;
            }
            if(s<0){
                s=0;
            }
       }
       return mx;
    }
};