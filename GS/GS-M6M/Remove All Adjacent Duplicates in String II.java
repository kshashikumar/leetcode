class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){

            int len = sb.length();
            if(len > 0 && sb.charAt(len-1) == s.charAt(i)){
                st.push(st.pop()+1);
            } else {
                st.push(1);
            }

            sb.append(s.charAt(i));

            if(st.peek() == k){
                sb.setLength(sb.length() - k);
                st.pop();
            }
        }

        return sb.toString();
    }
}