class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m*n-1;

        while(l<=r){
           int mid = l +(r-l)/2;

           int val = matrix[mid/n][mid%n];
           System.out.println(val+" "+l+" "+r);

           if(val == target){
            return true;
           } else if(val < target){
            l= mid+1;
           } else {
            r =mid-1;
           }
        }
        return false;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}