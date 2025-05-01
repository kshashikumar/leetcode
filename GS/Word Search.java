class Solution {

    public boolean callBacktrack(char[][] board, String word,int wi, int i, int j){
        int nr = board.length,nc = board[0].length;

        if( i<0 || i>=nr || j<0 || j>=nc || board[i][j] != word.charAt(wi)){
            return false;
        }
        if(wi == word.length()-1){
            return true;
        } 

        char t = board[i][j];
        board[i][j] ='#';

        boolean found =  callBacktrack(board,word,wi+1,i+1,j) 
        || callBacktrack(board,word,wi+1,i-1,j) 
        || callBacktrack(board,word,wi+1,i,j+1)
        || callBacktrack(board,word,wi+1,i,j-1);

        board[i][j] = t;
        return found;
    }

    public boolean exist(char[][] board, String word) {
       for(int i = 0;i<board.length;i++){
        for(int j = 0;j<board[0].length;j++){
            if(board[i][j] == word.charAt(0)){
                 if(callBacktrack(board,word,0,i,j)){
                    return true;
                 }
            }
        }
       }
       return false;
    }
}
