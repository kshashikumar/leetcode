public class Continuous
Subarray Sum
{
        // Calculate the prefix sum and then calculate the prefix mod with k, check if we have a similar prefixmod in map or else store it, if we find a similar prefix mod then check the indexes if the difference is greater than 2 then we have a solution else not. Initially we store (0,-1) to handle that first value if gives mod zero then it should return false as length of subarray should be 2 or greater
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        mp.put(0, -1);
        int pSum = 0;

        for (int i = 0; i < nums.length; i++) {
            pSum = pSum + nums[i];
            int pMod = pSum % k;
            if (mp.containsKey(pMod)) {
                int t = mp.get(pMod);

                if (i - t >= 2) {
                    return true;
                }
            } else {
                mp.put(pMod, i);
            }
        }

        return false;
    }
}
