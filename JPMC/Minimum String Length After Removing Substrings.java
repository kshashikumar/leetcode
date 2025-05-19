class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            
            if(!st.isEmpty() && st.peek() == 'A' && ch == 'B'){
                st.pop();
                continue;
            } else if(!st.isEmpty() && st.peek() == 'C' && ch == 'D'){
                st.pop();
                continue;
            } else {
                st.push(ch);
            }
        }

        return st.size();

    }
}