class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int l=i,r=i;

            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(sb.length() < (r-l+1)){
                    sb.setLength(0);
                    sb.append(s.substring(l, r+1));
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;

            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(sb.length() < (r-l+1)){
                    sb.setLength(0);
                    sb.append(s.substring(l,r+1));
                }
                l--;
                r++;
            }
        }
         return sb.toString();
    }
}