class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int rc=matrix[0].length-1,tr=0, br=matrix.length-1,lc=0;
        List<Integer> ans = new ArrayList<>();
       while(tr <= br && lc <= rc){
        
            for(int i=tr;i<=rc;i++){
                if(visited[tr][i] != 1 ){
                     ans.add(matrix[tr][i]);
                     visited[tr][i] =1;
                }
              
            }
            tr++;
            for(int i=tr;i<=br;i++){
                if(visited[i][rc] != 1 ){
                ans.add(matrix[i][rc]);
                visited[i][rc]=1;
                }
            }
            rc--;
            for(int i=rc;i>=lc;i--){
                if(visited[br][i] != 1 ){
                ans.add(matrix[br][i]);
                visited[br][i]=1;
                }
            }
            br--;
            for(int i=br;i>=tr;i--){
                if(visited[i][lc] != 1 ){
                ans.add(matrix[i][lc]);
                visited[i][lc]=1;
                }
            }
            lc++;
        }
       return ans;
    }
}