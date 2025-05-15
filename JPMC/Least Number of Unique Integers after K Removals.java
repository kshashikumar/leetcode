class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });

        for(int t:mp.keySet()){
            pq.add(new int[]{t,mp.get(t)});
        }

        while(k>0){
            int[] temp = pq.poll();
            if(temp[1]>1){
                temp[1]--;
                pq.offer(temp);
            }
            k--;
        }

        return pq.size();
    }
}