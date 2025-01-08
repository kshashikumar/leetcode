class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> places = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    List<Integer> pl = new ArrayList<>();
                    pl.add(i);
                    pl.add(j);
                    places.add(pl);
                    System.out.println("added");
                }  
            }
        }
        for(int i=0;i<places.size();i++){
            for(int k=0;k<matrix.length;k++){
                matrix[k][places.get(i).get(1)] =0;
            }
             System.out.println("ex:   "+places.get(i).get(1));
            for(int k=0;k<matrix[0].length;k++){
                matrix[places.get(i).get(0)][k] =0;
                System.out.println(" i : "+i+"  k: "+k);
            }
        }
    }
}