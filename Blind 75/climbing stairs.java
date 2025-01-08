class Solution {
    public List<Integer> dp;

    public Solution(){
        dp  = new ArrayList<>(Collections.nCopies(46,-1));
    }
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        } else if(n == 2){
            return 2;
        }  else if(dp.get(n) == -1){
            dp.set(n,climbStairs(n-1)+climbStairs(n-2));
        }
        return dp.get(n);
    }
}