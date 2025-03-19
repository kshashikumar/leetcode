public class Recrusive isPrime
{

    static boolean check(int n, int i) {
        if (i > Math.sqrt(n)) {
            return true;
        }
        if (n % i == 0) {
            return false;
        }
        return check(n, i + 1);
    }

    // Function to check if a number is prime or not.
    static boolean isPrime(int n) {
        return check(n, 2);
    }

    static boolean isPrime(int n) {
        // code here
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // System.out.println(i);
                return false;
            }
        }
        return true;
    }
}
