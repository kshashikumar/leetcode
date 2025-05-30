class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> mp = new LinkedHashMap<>();
        int[] cArr = new int[128];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            cArr[ch]++;
            mp.putIfAbsent(ch,i);
        }

        for(char key: mp.keySet()){
            if(cArr[key] == 1){
                return mp.get(key);
            }
        }
        return -1;
    }
}