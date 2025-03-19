static int fib(int n) {
    // Write your code here
    if (n <= 0) {
        return -1;
    }
    if (n == 1) {
        return 0;
    } else if (n == 2) {
        return 1;
    }
    return fib(n - 1) + fib(n - 2);
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(fib(n));
    scanner.close();
}