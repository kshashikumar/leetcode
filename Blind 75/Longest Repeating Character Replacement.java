class Solution {
    public int calMaxChar(Map<Character,Integer> mp){
        int mx=0;
        for(Integer m : mp.values()){
            mx = Math.max(mx,m.intValue());
        }
         return mx;
    }
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> mp =new HashMap<>();
        int l=0,r=0,ml=0,t=k;

        while(r<s.length()){
           mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
           int mxCh = calMaxChar(mp);
           if((r-l)+1-mxCh > k){
            mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)-1);
            l++;
           }
           if((r-l)+1 > ml){
            ml = (r-l)+1;
           }
           r++;
        }
        return ml;
    }
}