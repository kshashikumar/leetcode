
class Solution {

    public int[] mergeSort(int[] nums) {
        return mSort(nums, 0, nums.length);
    }

    public int[] mSort(int[] nums, int low, int high) {
        if (high - low <= 1) {
            return Arrays.copyOfRange(nums, low, high);
        }

        int mid = low + (high - low) / 2;
        int[] left = mSort(nums, low, mid);
        int[] right = mSort(nums, mid, high);
        return merge(left, right, left.length, right.length);
    }

    public int[] merge(int[] nums1, int[] nums2, int n, int k) {
        int[] ans = new int[n + k];
        int i = 0, j = 0, t = 0;
        while (i < n && j < k) {
            if (nums1[i] <= nums2[j]) {
                ans[t++] = nums1[i++];
            } else {
                ans[t++] = nums2[j++];
            }
        }

        while (i < n) {
            ans[t++] = nums1[i++];
        }

        while (j < k) {
            ans[t++] = nums2[j++];
        }
        return ans;
    }
}
