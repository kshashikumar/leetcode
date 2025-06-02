class Solution {
    public int maxProfit(int[] prices) {
        int minV = Integer.MAX_VALUE, mxProfit = 0;

        for(int price: prices){
            if(price < minV){
                minV = price;
            } else {
                mxProfit = Math.max(mxProfit, price - minV);
            }
        }
        return mxProfit;
    }
}