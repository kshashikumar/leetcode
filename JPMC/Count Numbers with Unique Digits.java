class Solution {

//     Unique 1-digit: 10 (0–9)

// Unique 2-digit: 9 (choices for 1st digit) × 9 (choices for 2nd digit) = 81

// Total = 10 + 81 = 91 ✅



     public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
      int count =10; // n =1
      int product =9;
      int available =9;

      for(int i=2;i<=n && available>0;i++){

        product = product * available;
        count = count + product;
        available--;
      }
      return count;

    }

    public int perms(int n,int k){
        int result =1;

        while(k-->0){
            result =result *n;
            n--;
        }
        return result;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int count =0;
        count =10;
        for(int i=2;i<=n;i++){
            count = count + 9*perms(9,i-1);
        }
        return count;
    }
}