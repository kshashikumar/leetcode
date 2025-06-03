class Solution {

    public int calArea(int[][] grid, int i,int j){
        int nr = grid.length, nc = grid[0].length;

        if( i<0 || i>=nr || j<0 || j>= nc || grid[i][j] == 0 ){
            return 0;
        }

        grid[i][j] = 0;

        int area=1;

        area += calArea(grid, i+1, j);
        area += calArea(grid,i-1,j);
        area += calArea(grid,i,j+1);
        area += calArea(grid,i,j-1);

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int mxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int area = calArea(grid,i,j);
                    mxArea = Math.max(mxArea,area);
                }
            }
        }
        return mxArea;
    }
}