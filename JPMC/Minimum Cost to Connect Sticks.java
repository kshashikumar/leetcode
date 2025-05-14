class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<sticks.length;i++){
            pq.offer(sticks[i]);
        }
        int cost =0;

        while(pq.size() !=1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            cost +=sum;
            pq.offer(sum);
        }
        return cost;
    }
}