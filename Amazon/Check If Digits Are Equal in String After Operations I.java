class Solution {

    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] arr = new int[s.length()];

        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            n--;
        }
        return arr[0] == arr[1];
    }

    public boolean hasSameDigits(String s) {
        if (s.length() <= 1) {
            return false;
        }
        int i = 1;
        StringBuilder sb = new StringBuilder();
        while (s.length() >= 3) {
            if (i == s.length()) {
                i = 1;
                s = sb.toString();
                System.out.println(s);
                sb.setLength(0);
            } else {
                int first = s.charAt(i - 1) - '0';
                int second = s.charAt(i) - '0';
                int newDigit = (first + second) % 10;
                sb.append(newDigit);
                i++;
            }
        }
        return s.charAt(0) == s.charAt(1) ? true : false;
    }
}