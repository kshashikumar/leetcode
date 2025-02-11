public class Goat Latin
{
     // Get all the list of words and then check conditions mentined and build the words at last append words
    public List<String> getWords(String s) {
        List<String> ans = new ArrayList<>();
        int l = s.length() - 1;
        while (l >= 0) {

            if (s.charAt(l) != ' ') {
                l--;
            } else {
                ans.add(s.substring(l + 1, s.length()));
                s = s.substring(0, l);
                l--;
            }
        }
        ans.add(s);
        return ans;
    }

    public String toGoatLatin(String sentence) {

        List<String> lStrings = getWords(sentence);
        Collections.reverse(lStrings);

        for (int i = 0; i < lStrings.size(); i++) {
            char ch = lStrings.get(i).charAt(0);
            if (ch != 'a' && ch != 'A' && ch != 'e' && ch != 'E' && ch != 'i' && ch != 'I' && ch != 'o' && ch != 'O'
                    && ch != 'u' && ch != 'U') {
                lStrings.set(i, lStrings.get(i).substring(1, lStrings.get(i).length()) + ch);
            }
            lStrings.set(i, lStrings.get(i) + "ma" + "a".repeat(i + 1));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lStrings.size(); i++) {
            sb.append(lStrings.get(i));
            if (i != lStrings.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
