public class Linked
List Cycle
{
    // Initialize slow and fast pointers to head and head.next. Then iterate over fast and fast.next and fast.next.next and check if slow and fast are equal then return true else return false
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
