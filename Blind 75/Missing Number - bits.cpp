class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int l = nums.size(), xr=0,d=0;
        for(int i=0;i<nums.size();i++){
            xr ^= nums[i] ^ (i+1);
        }
       
        return xr;
    }
};