class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> s = new HashSet<>();

        for(int num:nums){
            s.add(num);
        }

        int mxLen =0;
        for(int num:s){
            if(s.contains(num - 1)){
                continue;
            }

            int len =1;

            while(s.contains(num+len)){
                len++;
            }
            mxLen = Math.max(mxLen,len);
        }

        return mxLen;

    }
}