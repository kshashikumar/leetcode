public class maxProfit {
    // Function to find the maximum profit.
    public int maxProfit(int[] prices) {
        int maxSum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            maxSum = Math.max(maxSum, (prices[i] - min));
        }
        return maxSum;
    }
}
