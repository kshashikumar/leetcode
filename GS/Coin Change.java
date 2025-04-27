public class Coin Change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int coin:coins){
            for(int j=coin;j<=amount;j++){
                dp[j] = Math.min(dp[j-coin]+1,dp[j]);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
