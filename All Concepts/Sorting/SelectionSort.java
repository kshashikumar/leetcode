
class Solution {

    public int[] selectionSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                }
            }
        }
        return nums;
    }
}
