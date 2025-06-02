class Solution {
    public Map<String,Double> mp; 
    int[][] directions = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    public double dfs(int n, int k, int row, int column){
        if(row<0 || row >= n || column <0 || column >= n){
            return 0.0;
        }

        if(k == 0){
            return 1.0;
        }

        String key = k+"-"+row+"-"+column;
        if(mp.containsKey(key)){
            return mp.get(key);
        }

        double prob =0.0;

        for(int[] dir : directions){
            int nr = row + dir[0];
            int nc = column + dir[1];
            prob += dfs(n,k-1,nr,nc)/8.0;
        }

        mp.put(key,prob);
        return prob;
    }

    public double knightProbability(int n, int k, int row, int column) {
        mp = new HashMap<>();
        return dfs(n,k,row,column);
    }
}