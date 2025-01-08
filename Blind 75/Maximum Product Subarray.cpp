class Solution {
public:
    int maxProduct(vector<int>& nums) {
       double lr=1,rl=1,mx=INT_MIN;
        for(double i=0;i<nums.size();i++){

            if(lr == 0) lr =1;
            if(rl ==0) rl =1;

            lr=lr*nums[i];
            rl=rl*nums[(nums.size()-1)-i];
            mx = max(max(lr,rl),mx);
        }
        return mx;
    }
};