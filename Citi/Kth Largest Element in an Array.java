package Citi;

public class Kth
Largest Element
in an Array
{
    // when finding Kth largest element insert values into a priority queue and pop all extra elements from PQ so that the peek of PQ will be the kth largest element

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
