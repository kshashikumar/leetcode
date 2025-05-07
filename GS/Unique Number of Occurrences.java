class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i:arr){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }

        Set<Integer> s = new HashSet<>(mp.values());
        if(s.size() == mp.size()){
            return true;
        }
        return false;
    }
}