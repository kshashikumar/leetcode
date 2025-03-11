package Citi;

public class Coin
Change Infinite
{
    // Initialize dp with -1, then iterate over coins and then coin to amount. and update each amount ways by adding dp[st][amount-coins[st]] + dp[st+1][amount] at last return dp[0][amount] which gives ways
    public int calculate(int[] coins, int st, int amount, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || st >= coins.length) {
            return 0;
        }

        if (dp[st][amount] != -1)
            return dp[st][amount];

        int include = calculate(coins, st, amount - coins[st], dp);
        int exclude = calculate(coins, st + 1, amount, dp);

        return dp[st][amount] = include + exclude;

    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return calculate(coins, 0, amount, dp);
    }

    // Initialize dp with 0 and amount+1, then iterate over coins and then coin to
    // amount. and update each amount ways by adding dp[j] + dp[j-coin] at last
    // return dp[amount] which gives ways
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        return dp[amount];
    }
}
