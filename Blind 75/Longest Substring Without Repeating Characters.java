class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,ml=0;
        StringBuilder sb = new StringBuilder();
        int[] cArr = new int[120];

        while(r<s.length()){
            if(cArr[s.charAt(r)-' '] == 0){
                cArr[s.charAt(r)-' ']++;
                sb.append(s.charAt(r));
                r++;
            } else {
                sb.deleteCharAt(0);
                cArr[s.charAt(l)-' ']--;
                l++;
            }
            if(sb.length()>ml){
                ml = sb.length();
            }
        }
        return ml;
    }
}