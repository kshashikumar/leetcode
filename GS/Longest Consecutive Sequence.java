public class Longest Consecutive Sequence {
    //optimal
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i: nums){
            s.add(i);
        }

        int mxLen =0;

        for(int i:s){
            if(s.contains(i-1)) continue;
            int len =1;
            while(s.contains(i + len)){
                len++;
            }
            mxLen = Math.max(mxLen, len);
        }
        return mxLen;
    }
    

    
    
    public int longestConsecutive(int[] nums) {
        if(nums.length <=0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        int mxLen = 1,curr = 0 , prev = pq.poll(), temp =1 ;

        while(!pq.isEmpty()){
            curr = pq.poll();
            if(prev == curr){
                continue;
            }
            if(prev+1 == curr){
                temp++;
               
            } else {
                temp =1;
            }
            mxLen = Math.max(mxLen,temp);
            prev = curr;
        }

        return mxLen;
    }
}
