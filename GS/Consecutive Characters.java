public class Consecutive Characters {
    public int maxPower(String s) {
        int l=0,r=0,mxLen=0;

        while(r<s.length()){
            if(s.charAt(l) == s.charAt(r)){
                mxLen = Math.max(mxLen, r-l+1);
            } else {
                l = r;
            }
            r++;
        }

        return mxLen;
    }
}
