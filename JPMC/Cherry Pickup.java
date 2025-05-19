class Solution {
    public int[][][] memo;
    public int[][] grid;
    public int n;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        this.memo = new int[n][n][n];
        this.grid = grid;

        for(int[][] row: memo){
            for(int[] col:row){
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }

        int res = Math.max(0,dfs(0,0,0));
        return res;
    }

    public int dfs(int r1,int c1, int r2){
        int c2 = r1+c1-r2;

        if(r1>=n || c1 >=n || r2>=n ||c2>=n || grid[r1][c1] == -1 || grid[r2][c2] == -1 ){
            return -999999;
        }

        if(r1 == n-1 && c1 == n-1){
            return grid[r1][c1];
        }

        if(memo[r1][c1][r2] != Integer.MIN_VALUE){
            return memo[r1][c1][r2];
        }

        int cherries = grid[r1][c1];
        if(r1 != r2 || c1 != c2){
            cherries +=grid[r2][c2];
        }

        int next = Math.max(
            Math.max(dfs(r1+1,c1,r2+1), dfs(r1,c1+1,r2+1)),
            Math.max(dfs(r1+1,c1,r2), dfs(r1,c1+1,r2))
        );

        cherries +=next;
        memo[r1][c1][r2] = cherries;

        return memo[r1][c1][r2];
    }

}