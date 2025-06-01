class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int t=0;
        while(t<nums.length){
            pq.offer(nums[t]);
            if(pq.size() > k){
                pq.poll();
            }
            t++;
        }
        return pq.poll();
    }
}