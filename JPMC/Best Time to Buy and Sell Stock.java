class Solution {
    public int maxProfit(int[] prices) {
        int minValue =Integer.MAX_VALUE,mxProfit = 0;

        for(int i=0;i<prices.length;i++){
            if(minValue > prices[i]){
                minValue = prices[i];
            } else {
                mxProfit = Math.max(mxProfit, (prices[i] - minValue));
            }
        }
        return mxProfit;
    }
}