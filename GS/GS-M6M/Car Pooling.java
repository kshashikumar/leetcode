class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] dist = new int[1001];

        for(int i=0;i<trips.length;i++){
            int passengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            dist[from] += passengers;
            dist[to] -= passengers;
        }

        int change =0;

        for(int d: dist){
            change += d;
            if(change > capacity){
                return false;
            }
        }

        return true;

    }
}