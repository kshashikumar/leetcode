class Solution {
    public int[][] dp;

    public int calculate(int[][] grid, int sr, int sc){
        int r = grid.length, c = grid[0].length, right = Integer.MAX_VALUE, bottom = Integer.MAX_VALUE;

        if(sr == r-1 && sc  == c-1){
            return grid[sr][sc];
        }

        if(dp[sr][sc] !=-1){
            return dp[sr][sc];
        }

        if(sr+1<r){
            right = calculate(grid,sr+1,sc);
        }
        if(sc+1<c){
            bottom = calculate(grid,sr,sc+1);
        }

        dp[sr][sc] = grid[sr][sc] + Math.min(right,bottom);
        return dp[sr][sc];

    }

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        } 
        return calculate(grid,0,0);
    }
}