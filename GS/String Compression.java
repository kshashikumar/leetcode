package GS;

public class String Compression {
    public int compress(char[] chars) {
        
        int write=0,left=0;

        for(int r = 0; r<chars.length;r++){
            if(r == chars.length-1 || chars[r] != chars[r+1]){
                chars[write++] = chars[left];

                int count = r - left+1;
                if(count>1){
                    for(char ch : String.valueOf(count).toCharArray()){
                        chars[write++] = ch;
                    }
                }
                left = r+1;

            }
        }

        return write;
    }
}
