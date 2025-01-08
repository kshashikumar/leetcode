class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] cArr = new char[strs[i].length()+1];
            cArr = strs[i].toCharArray();
            Arrays.sort(cArr);
            if(mp.containsKey(String.valueOf(cArr))){
                List<String> temp = new ArrayList<>();
                temp = mp.get(String.valueOf(cArr));
                temp.add(strs[i]);
                String k = String.valueOf(cArr);
                
                mp.put(k,temp);
            } else {
                List<String> sArr = new ArrayList<>();
                sArr.add(strs[i]);
                String k= String.valueOf(cArr);
                mp.put(k,sArr);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String m : mp.keySet()){
           ans.add(mp.get(m));
        }
        return ans;
    }
}