public class Happy Number {
    class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();

        while(!s.contains(n)){
            if(n == 1){
                return true;
            }
             s.add(n);
            int dSum =0;
            int temp =n;
            while(temp!=0){
                int val = temp%10;
                dSum +=val*val;
                temp =temp/10;
            }
           
            n = dSum;
        }
        return false;
    }
}
}
