class Solution {
    public boolean helper(String s, int i, int j) {
        System.out.println(s.charAt(i) + "   " + s.charAt(j));
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Use two pointers method to check and update pointers, when the characters are
    // not equal call helper function by skiping the possible current start and end
    // characters
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1, c = 0;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return helper(s, i + 1, j) || helper(s, i, j - 1);
            }
            i++;
            j--;
        }

        return true;
    }
}
