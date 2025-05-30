class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(String str:strs){
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String temp = new String(cArr);
            mp.putIfAbsent(temp,new ArrayList<>());
            mp.get(temp).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for(String key: mp.keySet()){
            ans.add(mp.get(key));
        }
        return ans;
    }
}