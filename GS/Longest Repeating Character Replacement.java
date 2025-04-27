public class Longest Repeating Character Replacement {
    public int calMaxChar(Map<Character,Integer> mp){
        int mx=0;
        for(Integer t: mp.values()){
            mx = Math.max(mx,t);
        }
        return mx;
    }

    public int characterReplacement(String s, int k) {
        Map<Character,Integer> mp = new HashMap<>();

        int l=0,r=0,ml=0;

        while(r<s.length()){
            char ch = s.charAt(r);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            int mxChar = calMaxChar(mp);
            if((r-l+1)-mxChar > k){
                mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            if((r-l+1)> ml){
                ml = r-l+1;
            }
            r++;
        }
        return ml;
    }
}
