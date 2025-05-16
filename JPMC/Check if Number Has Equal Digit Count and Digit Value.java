class Solution {
    public boolean digitCount(String num) {
        Map<Integer,Integer> mp = new HashMap<>();

        char[] chArr = num.toCharArray();

        for(int i=0;i<chArr.length;i++){
            mp.put(chArr[i] - '0',mp.getOrDefault(chArr[i] - '0',0)+1);
        }

        for(int i=0;i<chArr.length;i++){
            if((chArr[i] - '0') != mp.getOrDefault(i,0)){
                return false;
            }
        }

        return true;

    }
}