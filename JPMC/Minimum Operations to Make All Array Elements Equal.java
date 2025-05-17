class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> ans = new ArrayList<>();
        int  n = nums.length;
        long[] prefix = new long[nums.length+1];

        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        for(int query:queries){
            int idx = Arrays.binarySearch(nums,query);
            if(idx <0){
                idx = -idx -1;
            }
            long leftCost = (long)query * idx - prefix[idx];
            long rightCost = ( prefix[n] - prefix[idx]) - (long)query * (n-idx);
            ans.add(leftCost + rightCost);
        }

        return ans;
    }
}