class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int tot=1;
        vector<int> v;
        vector<int> lp;
        vector<int> rp;
        lp.push_back(nums[0]);
        for(int i=1;i<nums.size();i++){
            lp.push_back(lp[i-1]*nums[i]);
        }
        
        rp.push_back(nums[nums.size()-1]);
        int k=0;
        for(int i=nums.size()-2;i>=0;i--){
            rp.push_back(rp[k]*nums[i]);
            k++;
        }
        cout<<endl;
        reverse(rp.begin(),rp.end());
        v.push_back(rp[1]);
        for(int i=1;i<nums.size()-1;i++){
           v.push_back(lp[i-1]*rp[i+1]);
        }
        v.push_back(lp[nums.size()-2]);
        return v;
    }
};