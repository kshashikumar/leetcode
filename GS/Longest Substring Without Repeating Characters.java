class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cArr = new int[128];
        int mxLen =0,l=0,r=0;

        while(r<s.length()){
            char t = s.charAt(r);
            cArr[t]++;
            while(cArr[t]>1){
                cArr[s.charAt(l)]--;
                l++;
            }
            mxLen = Math.max(mxLen,r-l+1);
            r++;
        }
        return mxLen;
    }
}