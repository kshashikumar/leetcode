class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // to store end days

        int res=0, day =0,i=0, n= events.length;

        while(i<n || !pq.isEmpty()){
            if(pq.isEmpty()){
                day = events[i][0]; //to store start day
            }

            // Add all starting today
            while(i<n && events[i][0]<=day){
                pq.offer(events[i++][1]);
            }
            
            //remove old events
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                res++;
                day++;
            }
        }
        return res;
    }
}