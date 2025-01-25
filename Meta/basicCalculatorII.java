import java.util.Stack;

public class basicCalculatorII {
    public int calculate(String s) {
        int ans = 0, curNum = 0;
        Stack<Integer> st = new Stack<>();
        Character sign = '+';

        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            if (Character.isDigit(s.charAt(i))) {
                curNum = curNum * 10 + d;
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    st.push(curNum);
                } else if (sign == '-') {
                    st.push(-curNum);
                } else if (sign == '*') {
                    st.push(st.pop() * curNum);
                } else if (sign == '/') {
                    st.push(st.pop() / curNum);
                }
                sign = s.charAt(i);
                curNum = 0;
            }
        }
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
