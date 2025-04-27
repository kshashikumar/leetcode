public class Find the Winner of the Circular Game {
    public int findTheWinner(int n, int k) {
        List<Integer> vals=new ArrayList<>();

        for(int i=0;i<n;i++){
            vals.add(i+1);
        }
        int t =0;
        while(vals.size() > 1){
           t = (t+k-1) % vals.size();
           vals.remove(t);
        }
        return vals.get(0);
    }
}
