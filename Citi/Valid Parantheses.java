public class Valid Parantheses
{
    // Function to check if the parantheses are valid or not
    public boolean isValid(String s) {
        int i = 0;
        Stack<Character> st = new Stack<>();
        while (i < s.length()) {
            if (!st.isEmpty() && s.charAt(i) == ')' && st.peek() == '(') {
                st.pop();
            } else if (!st.isEmpty() && s.charAt(i) == ']' && st.peek() == '[') {
                st.pop();
            } else if (!st.isEmpty() && s.charAt(i) == '}' && st.peek() == '{') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
            i++;
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}
