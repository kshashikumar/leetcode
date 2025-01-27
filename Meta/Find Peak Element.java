public class Find
Peak Element
{
    // Perform the binary search to find peak element, move low to mid+1 if m+1 is higher else move high to mid
    public int findPeakElement(int[] nums) {
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int m = (l + h) / 2;
            System.out.println(l + " " + h + "   " + m);
            if (m - 1 >= 0 && m + 1 <= nums.length - 1 && nums[m - 1] < nums[m] && nums[m + 1] < nums[m]) {
                return m;
            }
            if (m + 1 <= nums.length - 1 && nums[m + 1] > nums[m]) {

                l = m + 1;

            } else if (m + 1 <= nums.length - 1 && nums[m + 1] < nums[m]) {
                h = m;
            }
        }
        return l;
    }
}
