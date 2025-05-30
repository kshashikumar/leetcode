class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

        for(int[] temp : items){
            int id = temp[0];
            int mark = temp[1];

            if(!mp.containsKey(id)){
                mp.put(id, new PriorityQueue<>(Collections.reverseOrder()));
            }
            mp.get(id).add(mark);
        }

        int[][] ans = new int[mp.size()][2];
        int t=0;
        for(int key:mp.keySet()){
            int[] arr = new int[2];
            arr[0] = key;
            int sum =0;
            for(int  i=0;i<5;i++){
                sum += mp.get(key).poll();
            }
            arr[1] = sum/5;
            ans[t++] = arr;
        }

        return ans;
    }
}