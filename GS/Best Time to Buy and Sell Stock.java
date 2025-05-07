class Solution {
    public int maxProfit(int[] prices) {
        int mxProfit =0,minPrice=Integer.MAX_VALUE;
        for(int price:prices){
            if(price<minPrice){
                minPrice = price;
            } else{
                mxProfit = Math.max(mxProfit,price-minPrice);
            }
        }
        return mxProfit;
    }
}