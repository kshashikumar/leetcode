class Solution {

    public boolean isAnagram(String a,String b){
        char[] t1 = a.toCharArray();
        char[] t2 = b.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        return Arrays.equals(t1,t2);
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for(int i=1;i<words.length;i++){
           if(!isAnagram(words[i],result.get(result.size()-1))){
                result.add(words[i]);
           }
        }

        return result;

    }
}