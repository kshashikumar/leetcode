package Citi;

public class Coin
Change Minimum coins
{
    // Initialize dp with -1, then iterate over coins and then coin to amount. and update each amount ways by adding min of ways and res+1 and then return dp[amount] which gives ways
    public int calculate(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1)
            return dp[amount];

        int ways = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = calculate(coins, amount - coins[i], dp);
            if (res != Integer.MAX_VALUE) {
                ways = Math.min(ways, res + 1);
            }
        }
        return dp[amount] = ways;

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int res = calculate(coins, amount, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // DP solution
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
