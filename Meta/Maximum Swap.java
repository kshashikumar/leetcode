public class Maximum Swap
{
    
    //Store digit indexes in map, and then check the highest value next to the digit and swap it
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] last = new int[10];

        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    int lt = last[d];
                    char ch = digits[i];
                    digits[i] = digits[lt];
                    digits[lt] = ch;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
}
