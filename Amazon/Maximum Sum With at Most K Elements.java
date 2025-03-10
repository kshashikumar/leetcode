public class Maximum Sum With at Most K Elements {
     // Intially sort the values in the internal arrays and take the values from last according to limits into the array and then sort it and take last k values
     public long maxSum(int[][] grid, int[] limits, int k) {
        long sum=0;
        for(int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]);
        }
        List<Integer> ans = new ArrayList<>();
         for(int i=0;i<grid.length;i++){
            int t=limits[i],q = grid[i].length-1;
           while(t>0){
            ans.add(grid[i][q]);
            q--;
            t--;
           }
         }
         Collections.sort(ans);
        int q = ans.size()-1;
         while(k>0){
            sum +=ans.get(q);
            q--;
            k--;
         }        
        return sum;
    }
}
