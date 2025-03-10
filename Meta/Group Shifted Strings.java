public class Group
Shifted Strings
{

    public String getPattern(String s) {
        if (s.length() == 1)
            return "single";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            int d = (s.charAt(i + 1) - s.charAt(i) + 26) % 26;
            sb.append(d + ",");
        }
        return sb.toString();

    }

    // calculate the pattern for each of the string, pattern here if the difference
    // between each character in string and based on that pattern group strings.
    // Take a note of adding 26 and doing modulo as the characters can be from left
    // to right or right to left
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mp = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String d = getPattern(strings[i]);
            if (!mp.containsKey(d)) {
                mp.put(d, new ArrayList<>());
            }
            mp.get(d).add(strings[i]);
        }
        return new ArrayList<>(mp.values());
    }
}
