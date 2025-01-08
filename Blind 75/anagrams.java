class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            //System.out.println("m: "+mp.containsKey(t.charAt(i))+ "  s.charAt(i)  " +s.charAt(i));
            if(mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            } else {
                mp.put(s.charAt(i),1);
            }
        }
         for(int i=0;i<t.length();i++){
           // System.out.println("m: "+mp.containsKey(t.charAt(i))+ "  t.charAt(i)  " +t.charAt(i));
            if(mp.containsKey(t.charAt(i))){
                mp.put(t.charAt(i),mp.get(t.charAt(i))-1);
            } 
         }

         for(Character m:mp.keySet()){
            System.out.println("m: "+m+ "  mp  " +mp.get(m));
            if(mp.get(m) == null || mp.get(m) == 0){
                continue;
            } else {
                return false;
            }
         }
         return true;
    }
}