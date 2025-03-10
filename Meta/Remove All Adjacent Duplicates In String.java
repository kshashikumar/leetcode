public class Remove
All Adjacent
Duplicates In String
{
    
    // use stack to put each character and pop character if peek is the same character. At lastconstruct a string with stack values and reverse it
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
