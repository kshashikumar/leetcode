public class Reorganize String
{
     // Initially get the chars count and ten add the entries to priorityQueue such that the values are sorted and then check if any max from values is greater than half of string length and then append top key and store it as prev and then append next and restore prev, continue all process untill priorityqueue is empty
    public String reorganizeString(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        Map<Character, Integer> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> ch : mp.entrySet()) {
            pq.add(ch);
        }
        int mxL = Collections.max(mp.values());
        if (mxL > (s.length() + 1) / 2) {
            return "";
        }

        Map.Entry<Character, Integer> prev = null;

        while (!pq.isEmpty()) {

            Map.Entry<Character, Integer> d = pq.poll();

            sb.append(d.getKey());
            d.setValue(d.getValue() - 1);

            if (prev != null && prev.getValue() > 0) {
                pq.add(prev);
            }
            prev = d;

        }

        return sb.length() == s.length() ? sb.toString() : "";

    }
}
