public class Merge
Strings Alternately
{
     // Initially merge the strings based on even odd values of a counter and then add the rest of values from each string
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, t1 = 0, t2 = 0;
        while (t1 < word1.length() && t2 < word2.length()) {
            if (i % 2 == 0) {
                sb.append(word1.charAt(t1));
                t1++;
            } else {
                sb.append(word2.charAt(t2));
                t2++;
            }
            i++;
        }

        while (t1 < word1.length()) {
            sb.append(word1.charAt(t1));
            t1++;
        }

        while (t2 < word2.length()) {
            sb.append(word2.charAt(t2));
            t2++;
        }

        return sb.toString();
    }
}
