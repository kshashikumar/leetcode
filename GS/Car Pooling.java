class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1001];

        for(int i=0;i<trips.length;i++){
            int numOfPassengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            d[from] +=numOfPassengers;
            d[to] -=numOfPassengers;
        }

        int change = 0;
        for(int i:d){
            change +=i;
            if(change>capacity){
                return false;
            }
        }
        return true;
    }
}