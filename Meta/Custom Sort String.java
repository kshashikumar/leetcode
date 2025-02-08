public class Custom
Sort String
{
    
    //Initially store the priority of characters in the map and then sort the other string based on map priority, so we get a permutation without actually calculating all permutations 
    public String customSortString(String order, String s) {

        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            mp.put(order.charAt(i), i);
        }

        Character[] cArr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cArr[i] = s.charAt(i);
        }

        Arrays.sort(cArr, (a, b) -> mp.getOrDefault(a, 26) - mp.getOrDefault(b, 26));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cArr.length; i++) {
            sb.append(cArr[i]);
        }

        return sb.toString();

    }
}
