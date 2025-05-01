public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        for(Integer key:mp.keySet()){
            pq.add(new int[]{key,mp.get(key)});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int t=0;
        while(!pq.isEmpty()){
            ans[t++] = pq.poll()[0];
        }

        return ans;

    }
} {
    
}
