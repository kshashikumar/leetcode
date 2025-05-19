class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] result = new int[k];

        int[][] indexqueries = new int[k][2];
       

        for(int i=0;i<queries.length;i++){
            indexqueries[i][0] = queries[i];
            indexqueries[i][1] = i;
        }

        Arrays.sort(indexqueries, Comparator.comparingInt(a -> a[0]));

        //[grid[x][y], x, y]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        pq.offer(new int[]{grid[0][0],0,0});
        visited[0][0] = true;
        int count=0;

        for(int[] temp:indexqueries){
            
            int qIdx = temp[1], qVal = temp[0];

            while(!pq.isEmpty() && pq.peek()[0] < qVal){
                
                int[] prev  = pq.poll();
                int r  = prev[1], c = prev[2];
                count++;

                for(int[] d: directions){
                    int nr = r + d[0], nc = c + d[1];

                    if(nr>=0 && nc >=0 && nr < m && nc < n &&  !visited[nr][nc]){
                        pq.offer(new int[]{grid[nr][nc],nr,nc});
                        visited[nr][nc] = true;
                    }
                }   
            }
            result[qIdx] = count;
        }

        return result;
    }
}