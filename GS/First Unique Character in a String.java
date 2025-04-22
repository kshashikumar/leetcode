package GS;

public class First Unique Character in a String {
    public int firstUniqChar(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int[] cArr = new int[126];

        for(int i=0;i<s.length();i++){
            cArr[s.charAt(i)-'0']++;
            if(cArr[s.charAt(i)-'0']>1){
                continue;
            }
            mp.put(s.charAt(i),i);
        }
        int ans=Integer.MAX_VALUE;
        for(Character ch :mp.keySet()){
            if(mp.get(ch) < ans && cArr[ch-'0'] ==1){
                ans = mp.get(ch);
            }
        }
        return ans == Integer.MAX_VALUE? -1: ans;
    }
}
