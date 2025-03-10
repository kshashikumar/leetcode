public class Longest
Common Prefix
{
    
    // Iterate over the first string and compare the characters of first string with all the strings same index, If we find any other character return the ans string built until that position and check edge cases when string is empty and if a whole string is answer and also the strings length might not be same
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0] == "")
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }

        return strs[0];
    }
}
