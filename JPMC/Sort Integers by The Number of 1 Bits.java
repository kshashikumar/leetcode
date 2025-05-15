class Solution {

    public int countBits(int n){
        int count =0;

        while(n!=0){
            count = count + (n&1);
            n = n >>1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxedArr,(a,b) -> {
            int aCount = countBits(a);
            int bCount = countBits(b);

            if( aCount  == bCount){
                return a - b;
            }
            return aCount - bCount;

        });
        return Arrays.stream(boxedArr).mapToInt(i -> i).toArray();
    }
}