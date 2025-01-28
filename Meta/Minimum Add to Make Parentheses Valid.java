public class Minimum
Add to
Make Parentheses Valid
{
    // use stack to add ) when an ( is found and pop when ) is found, if we have extra ), add them to answer and at last pop extra )'s and add to answer
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    ans++;
                }
            }
        }

        while (!st.isEmpty()) {
            st.pop();
            ans++;
        }
        return ans;
    }
}
