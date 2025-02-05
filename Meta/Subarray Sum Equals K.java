public class Subarray
Sum Equals K
{
     
    // In this problem,take a map and store the count or each prefix sum and increment counts of each sum if found in map, to get the count try checking if there is any entry with sum - k, which means removing target and checking if there are already entries based sum -k so that it equals to 0
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int count = 0;

        mp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);

        }

        return count;
    }
}
