class Solution {
    public boolean callBacktrack(char[][] board,String word,int wi,StringBuilder sb, int r,int c,int nr,int nc){ 
        sb.append(board[r][c]);
        if(sb.toString().equals(word)){
            return true;
        } else {
            char t = board[r][c];
            board[r][c]='#';
           // System.out.println("word : "+word.charAt(wi+1)+"  board: "+board[r][c+1]);
            if(c+1 < nc && board[r][c+1] == word.charAt(wi+1)){
                if(callBacktrack(board,word,wi+1,sb,r,c+1,nr,nc))
                {
                    return true;
                }
            }  if(r+1 < nr && board[r+1][c] == word.charAt(wi+1)){
                if(callBacktrack(board,word,wi+1,sb,r+1,c,nr,nc)){
                    return true;
                }
            }  if(r-1 >= 0 && board[r-1][c] == word.charAt(wi+1)){
                if(callBacktrack(board,word,wi+1,sb,r-1,c,nr,nc)){
                    return true;
                }
            }  if(c-1 >= 0 && board[r][c-1] == word.charAt(wi+1)){
                if(callBacktrack(board,word,wi+1,sb,r,c-1,nr,nc)){
                    return true;
                }
            }
            board[r][c]=t;
        }
        sb.setLength(sb.length() - 1);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    StringBuilder sb = new StringBuilder();
                    if(callBacktrack(board,word,0,sb,i,j,board.length,board[0].length)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}