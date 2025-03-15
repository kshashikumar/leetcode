public class Merge
k Sorted Lists
{
    // when merging k sorted lists, we can use a priority queue to store the head of each list and poll the smallest element from the queue and add it to the result list. If the polled element has a next element, we add it to the queue. We repeat this process until the queue is empty.
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return ans.next;

    }
}
