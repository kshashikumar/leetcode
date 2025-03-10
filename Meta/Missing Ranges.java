public class Missing Ranges
{
    // check the prev as lower initially and then check difference with current if the difference is > 1 add the values to list, do same until the upper value and end of list
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        long prev = (long) lower - 1;

        for (int i = 0; i <= nums.length; i++) {
            long cur = (i == nums.length) ? (long) upper + 1 : nums[i];

            if ((cur - prev) > 1) {
                ans.add(new ArrayList(Arrays.asList(prev + 1, cur - 1)));
            }

            prev = cur;
        }
        return ans;
    }
}
