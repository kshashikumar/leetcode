import java.util.*;
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);

        Vector<Integer> v = new Vector<>();
        if(stones.length == 1){
            return stones[0];
        }

        for(int i=0;i<stones.length;i++){
            v.add(stones[i]);
        }
Collections.sort(v);
        while(v.size() > 1){
            int diff = v.get(v.size() - 1) - v.get(v.size() - 2);
            //System.out.println(diff);
            if(diff ==0) {
                v.remove(v.size() - 1);
                v.remove(v.size() - 1);
            } else if(diff>0){
                v.set(v.size() - 2, diff);
                v.remove(v.size() - 1);
                Collections.sort(v);
            }
        }
        return v.size() > 0 ? v.get(0): 0;
    }
}



// optimal

import java.util.*;
class Solution {
    public int lastStoneWeight(int[] stones) {
       
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

       for(int i=0;i<stones.length;i++){
        pq.add(stones[i]);
       }

       while(pq.size() >1){
        int le = pq.poll(), ls = pq.peek();
        if(le == ls){
            pq.poll();
        } else if(le - ls > 0){
            pq.poll();
            pq.add(le-ls);
            
        }
       }

       return pq.size() > 0? pq.poll() : 0;
    }
}