class Solution {
    // use a pointer to get the pathnames and add them to stack and if there is a
    // .., remove the last element from stack
    public String simplifyPath(String path) {
        String ans = "", temp = "";
        int i = 0;

        Stack<String> st = new Stack<>();

        for (i = 0; i <= path.length(); i++) {
            Character curr = i < path.length() ? path.charAt(i) : '/';

            if (curr == '/') {
                if (temp.length() > 0) {

                    if (temp.equals("..")) {
                        if (!st.isEmpty())
                            st.pop();
                    } else if (!temp.equals(".")) {
                        st.push(temp);
                    }

                }
                temp = "";
            } else {
                temp += path.charAt(i);
            }
        }

        while (!st.isEmpty()) {
            String t = st.pop();

            ans = "/" + t + ans;
        }
        return ans.length() == 0 ? "/" : ans;
    }
}