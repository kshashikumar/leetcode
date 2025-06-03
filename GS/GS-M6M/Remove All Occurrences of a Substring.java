class Solution {
    public String removeOccurrences(String s, String part) {
        int pLen = part.length();
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()){
            sb.append(ch);

            while(sb.length()>=pLen && sb.substring(sb.length()-pLen).equals(part)){
                sb.delete(sb.length()-pLen, sb.length());
            }
        }

        return sb.toString();
    }
}