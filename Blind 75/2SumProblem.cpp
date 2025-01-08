class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> v;
        map<int,int> m;
        int x=target;
        for(int i=0;i<nums.size();i++){
            x=target;
            cout<<"before "<<x<<endl;
            x=x-nums[i];
            cout<<x<<endl;
            if(m.find(x)!=m.end()){
                v.push_back(i);
                v.push_back(m[x]);
                return v;
            } else {
                    m[nums[i]]=i;

            }
            
        }
        return v;
    }
};