class Solution {
    public boolean winnerOfGame(String colors) {
        char[] chArr = colors.toCharArray();
        int count =1, aMoves =0,bMoves =0;
        for(int i=1;i<chArr.length;i++){
            if(chArr[i] == chArr[i-1]){
                count++;
            } else {
                if(count>=3){
                    if(chArr[i-1] == 'A'){
                        aMoves += count -2; 
                    } else {
                        bMoves += count -2;
                    }
                }
                count =1;
            }
        }

        if(count>=3){
            if(chArr[chArr.length-1] == 'A'){
                aMoves += count-2; 
            } else {
                bMoves += count -2;
            }
        }
        return aMoves > bMoves;
    }
}