class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ll =prices[0];
        int profit=0;
        for(int i=1;i<prices.size();i++){
            int x=0;
            if(ll<prices[i]){
                x =  prices[i] - ll;
            }
            cout<<ll<<"  "<<prices[i]<<endl;
            if(profit<x){
                cout<<profit<<endl;
                profit=x;
            }
            if(ll>prices[i]){
                ll = prices[i];
            } 
        }
        return profit;
    }
};