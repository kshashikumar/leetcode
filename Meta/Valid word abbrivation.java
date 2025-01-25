class Solution {
    // check if the current character is a digit and construct the number else move
    // the pointers on word and abbr and check if not cases
    public boolean validWordAbbreviation(String word, String abbr) {
        int num = 0, k = 0;
        if (abbr.length() > word.length())
            return false;
        for (int i = 0; i < abbr.length(); i++) {

            if (Character.isDigit(abbr.charAt(i))) {
                int d = abbr.charAt(i) - '0';
                if (num == 0 && d == 0) {
                    return false;
                }
                num = num * 10 + d;
            } else {
                k += num;
                num = 0;
                if (num + k >= word.length() || word.charAt(k) != abbr.charAt(i)) {

                    return false;
                }
                k++;
            }
        }
        return k + num == word.length();
    }
}