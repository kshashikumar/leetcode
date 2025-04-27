public class Group Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String s = new String(chArr);
            if(!mp.containsKey(s)){
                mp.put(s,new ArrayList<>());
            }
            mp.get(s).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String ch: mp.keySet()){
            ans.add(mp.get(ch));
        }
        return ans;

    }
}
