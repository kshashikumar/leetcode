class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,mxl = Integer.MIN_VALUE;
        int[] cArr = new int[128];

        while(r<s.length()){
            char ch = s.charAt(r);
            cArr[ch]++;

            while(cArr[ch]>1){
                cArr[s.charAt(l)]--;
                l++;
            }
            mxl = Math.max(mxl,(r-l+1));
            r++;
        }

        return mxl == Integer.MIN_VALUE?0: mxl;

    }
}