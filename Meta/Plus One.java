public class Plus One
{
       // Iterate from last and check if digit is less than 9 then add 1 and return if digit is 9 make it zero and move to left. If all digits are 9 then construct new int[] and place 1 at start with n+1 size
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
