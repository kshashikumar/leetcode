class Solution {

    public int findMaxChar(Map<Character,Integer> mp){
        int mx =0;
        for(int val: mp.values()){
            mx = Math.max(mx,val);
        }
        return mx;
    }

    public int characterReplacement(String s, int k) {
        Map<Character,Integer> mp = new HashMap<>();

        int l=0,r=0,ml=0;

        while(r<s.length()){
            char ch = s.charAt(r);
            mp.put(ch, mp.getOrDefault(ch,0)+1);

            int mxChar = findMaxChar(mp);

            while((r-l+1) - mxChar > k){
                mp.put(s.charAt(l), mp.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            ml = Math.max(ml,(r-l+1));

            r++;
        }

        return ml;
    }
}