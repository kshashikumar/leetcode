class Solution {
    public int countBinarySubstrings(String s) {
        int prevG =0, curG =1, count =0;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curG++;
            } else {
                count = count + Math.min(prevG,curG);
                prevG =curG;
                curG=1;
            }
        }
        count = count + Math.min(prevG,curG);
        return count;
    }
}