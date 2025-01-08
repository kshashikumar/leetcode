class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        int i=0;
        uint32_t s=0;
        while(i<32){
            int lB = n&1;
            
            cout<<lB;
            if(lB == 1){
                //cout<<31<<" "<<i<<" "<<(31-i)<<endl;
                cout<<pow(2,31-i)<<endl;
               s=s+pow(2,31-i);
            }
            i++;
            n = n>>1;
        }
        return s;
    }
};