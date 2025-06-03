class Solution {
    public int numTeams(int[] rating) {
        int count =0;

        for(int i=0;i<rating.length;i++){
            int leftSmaller = 0, leftGreater =0, rightSmaller =0, rightGreater =0;

            for(int j = 0;j<i;j++){
                if(rating[j]<rating[i]){
                    leftSmaller++;
                } else {
                    leftGreater++;
                }
            }

            for(int j =i+1;j<rating.length;j++){
                if(rating[j] < rating[i]){
                    rightSmaller++;
                } else {
                    rightGreater++;
                }
            }

            count += leftSmaller * rightGreater;
            count += leftGreater * rightSmaller;
        }
        return count;

    }
}