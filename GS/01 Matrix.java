class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    res[i][j] = 0;
                    q.offer(new int[]{i,j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int r =cell[0], c = cell[1];

            for(int[] dir:dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
  
                if(res[nr][nc] > res[r][c]+1){
                    res[nr][nc] = res[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
                }
            }

        }


        return res;
    }
}