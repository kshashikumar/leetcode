class Solution {
public:
    int foo(int n){
        int c=0;
        while(n!=0){
            if((n&1) ==1){
                c++;
            }
            n>>=1;
        }
        return c;
    }
    vector<int> countBits(int n) {
        vector<int>  v;
        for(int i=0;i<=n;i++){
            v.push_back(foo(i));
        }
        return v;
    }
};