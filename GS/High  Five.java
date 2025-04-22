package GS;

public class High  Five {
    public int[][] highFive(int[][] items) {
        Map<Integer,PriorityQueue<Integer>> mp = new HashMap<>();
        for(int i=0;i<items.length;i++){
            if(!mp.containsKey(items[i][0])){
                mp.put(items[i][0],new PriorityQueue<>(Collections.reverseOrder()));
            }
            mp.get(items[i][0]).add(items[i][1]);
        }
        int[][] ans = new int[mp.size()][2];
        int p=0;
        for(Integer k: mp.keySet()){
            int sum =0;
            for(int j = 0;j<5;j++){
                sum+= mp.get(k).poll();
            }
            int[] t= new int[2];
            t[0] = k;
            t[1] = sum/5;
            ans[p++] =t;
        }
        return ans;
    }
}
