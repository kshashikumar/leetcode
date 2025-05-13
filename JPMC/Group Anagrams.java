class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String temp = String.valueOf(chArr);
            if(!mp.containsKey(temp)){
                mp.put(temp,new ArrayList<>());
            }
            mp.get(temp).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String s: mp.keySet()){
            ans.add(mp.get(s));
        }
        return ans;
    }
}