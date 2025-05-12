class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count =0;

        for(int t:time){
            int mod = t%60;
            int complement  = (60 - mod)%60;

            count+=remainders[complement];
            remainders[mod]++;
        }
        return count;

    }
}