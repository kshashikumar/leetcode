public class Top
K Frequent Elements
{

    
    //Initially add all values to map and collect the frequency, then push pairs of {value, freq} to priority queue by defaultly sorting pq based on values and at last construct int array
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }

        for (int i : mp.keySet()) {
            pq.add(new int[] { i, mp.get(i) });
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int m = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            ans[m] = temp[0];
            m++;
        }

        return ans;
    }

}
