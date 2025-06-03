class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            mp.put(words[i],i);
        }

        for(int i =0;i<words.length;i++){
            String word = words[i];
            for(int j=0;j<=word.length();j++){
                String prefix = word.substring(0,j);
                String suffix = word.substring(j);


                if(isPalindrome(suffix)){
                    String revPrefix = new StringBuilder(prefix).reverse().toString();
                    if(mp.containsKey(revPrefix) && mp.get(revPrefix) != i){
                        ans.add(Arrays.asList(i, mp.get(revPrefix)));
                    }
                }

                if(j !=0 && isPalindrome(prefix)){
                    String revSuffix = new StringBuilder(suffix).reverse().toString();

                    if(mp.containsKey(revSuffix) && mp.get(revSuffix) != i){
                        ans.add(Arrays.asList(mp.get(revSuffix),i));
                    }
                }

            }
        }

        return ans;
    }

    public boolean isPalindrome(String temp){
        int l = 0 , r = temp.length()-1;

        while(l<=r){
            if(temp.charAt(l) != temp.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}