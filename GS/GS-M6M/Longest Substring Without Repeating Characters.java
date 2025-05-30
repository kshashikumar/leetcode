class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cArr = new int[128];
        int mxLen =0,r=0,l=0;

        while(r<s.length()){
            char ch = s.charAt(r);
            cArr[ch]++;

            while(cArr[ch] >1){
                cArr[s.charAt(l)]--;
                l++;
            }
            mxLen = Math.max(mxLen, r-l+1);
            r++;
        }

        return mxLen;
    }
}