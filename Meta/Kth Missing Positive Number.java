public class Kth
Missing Positive Number
{
      // Increment K until you find a array element that is greater than k and return k, this will give you the exact mising element as it adds the lesser numbers denoting the increments in answer, which comes to a solution
    public int findKthPositive(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else {
                break;
            }
        }

        return k;
    }
}
