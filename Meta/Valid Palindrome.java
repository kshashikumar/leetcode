public class Valid Palindrome
{
    
    // In this construct a string which will only have alphanumeric characcters from original string and themn check if string is palindrome or not
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        int i = 0, j = sb.length() - 1;
        String ans = sb.toString().toLowerCase();
        while (i < j) {
            if (ans.charAt(i) == ans.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
