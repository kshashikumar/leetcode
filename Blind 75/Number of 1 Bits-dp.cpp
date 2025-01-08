class Solution {
public:
    vector<int> countBits(int n) {
        vector<int>  v;
        if(n>=0){
            v.push_back(0);
        } 
        if(n>=1){
            v.push_back(1);
        }         
        for(int i=2;i<=n;i++){
            v.push_back(v[i/2]+v[i%2]);
        }
        return v;
    }
};