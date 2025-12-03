
class Solution {

    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0) {
                if (nums[j - 1] > nums[j]) {
                    int t = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = t;
                }
                j--;
            }
        }
        return nums;
    }
}
