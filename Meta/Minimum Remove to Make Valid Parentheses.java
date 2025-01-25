class Solution {

    // Use Stack and set, push indexes into stack when ( is found and pop when ) are
    // found, if extra ) are found add them to set and at end add extra stack values
    // to set, and then build new string removing characters from string
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> stt = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            }
            if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    stt.add(i);
                }
            }
        }
        while (!st.isEmpty()) {
            stt.add(st.pop());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!stt.contains(i)) {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }
}