class Solution {
    public int maxPower(String s) {
        int l=0,r=0,mxlen=0;

        while(r<s.length()){
            if(s.charAt(l) == s.charAt(r)){
                mxlen = Math.max(mxlen,r-l+1);
            } else {
                l=r;
            }
            r++;
        }
        return mxlen;

    }
}