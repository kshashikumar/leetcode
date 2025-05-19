class Solution {
    public int minInsertions(String s) {
        int open=0, insertions=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            } else {
                if(i+1 < s.length() && s.charAt(i+1) ==')'){
                    if(open>0){
                        open--;
                    } else {
                        insertions++;
                    }
                    i++;
                } else {
                    //for single )
                    if( open >0){
                        open--;
                        insertions++;
                    } else {
                        // for one ( and )
                        insertions+=2;
                    }
                }
            }
        }
        insertions += open *2 ;
        return insertions;
    }
}