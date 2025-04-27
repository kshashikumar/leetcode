public class Number of Islands {
    public void fillMatrix(char[][] grid,int st,int ed){
        if(st<0 || st>=grid.length || ed<0 || ed>=grid[0].length || grid[st][ed] == '0'){
            return;
        }
        grid[st][ed] = '0';
        fillMatrix(grid,st+1,ed);
        fillMatrix(grid,st-1,ed);
        fillMatrix(grid,st,ed+1);
        fillMatrix(grid,st,ed-1);
    }
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    fillMatrix(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}
