
class Solution {

    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                }
            }
        }
        return nums;
    }
}
