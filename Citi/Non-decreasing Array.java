package Citi;

public class Non-decreasing Array
{
    // Initially traverse through the array and then check if nums[i] < nums[i-1], then increment count. inside check if count>1 return false or else check if the last 2nd element is less than current and swap i with i-1, if not swap i-1 with i. at end return true;
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i - 2 < 0 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }

        }
        return true;
    }
}
