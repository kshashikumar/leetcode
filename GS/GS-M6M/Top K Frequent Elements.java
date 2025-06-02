class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int key : mp.keySet()){
            int[] temp = new int[2];
            temp[0] = key;
            temp[1] = mp.get(key);

            pq.offer(temp);
            while(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[pq.size()];
        int t=0;
        while(!pq.isEmpty()){
            ans[t++] = pq.poll()[0];
        }

        return ans;
    }
}