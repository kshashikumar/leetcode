class Solution {


    // nPk =  n * (n-1) ..... (n-k+1)
    public int perms(int n, int k){
        int result =1;

        while(k-- >0){
            result = result * n;
            n--;
        }
        return result;
    }

    public int numDupDigitsAtMostN(int n) {
        List<Integer> nums = new ArrayList<>();
        int tempN = n+1;

        while(tempN !=0){
            nums.add(0,tempN%10);
            tempN = tempN/10;
        }

        int count = 0;

        for(int i=0;i<nums.size()-1;i++){
            count += 9 * perms(9, i);
        }

        Set<Integer> seen = new  HashSet<>();

        for(int i=0;i<nums.size();i++){
            int curDigit = nums.get(i);
            for(int j = (i == 0?1:0);j<curDigit;j++){
                if(!seen.contains(j)){
                    count += perms(10 - (i+1),nums.size()-i-1);
                } 
            }
            if(seen.contains(curDigit)) break;
            seen.add(curDigit);

        }

        return n-count;
    }














    


    public boolean hasRepeated(int n){
        boolean[] seen = new boolean[10];

        while(n>0){
            
            if(seen[n%10] == true){
                return true;
            }
            seen[n%10] = true;
            n = n/10;
        }
        return false;

    }

    public int numDupDigitsAtMostN(int n) {
        int c=0;
        for(int i=1;i<=n;i++){
            if(hasRepeated(i)){
                c++;
            }
        }
        return c;

    }
}