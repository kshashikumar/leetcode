class Solution {
    public String smallestString(String s) {
        char[] cArr = s.toCharArray();
        int i=0, n = s.length();
        while(i<n && cArr[i] == 'a' ){
            i++;
        }

        if(i == cArr.length){
            cArr[cArr.length -1] = 'z';
            return new String(cArr);
        }

        while(i<n && cArr[i] != 'a'){
            cArr[i]--;
            i++;
        }

        return new String(cArr);
    }
}