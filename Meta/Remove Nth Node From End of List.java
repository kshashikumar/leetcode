public class Remove
Nth Node
From End
of List
{
    
    // Initially find the length of LL and then subtract the n from length, so you get the index of element which has to be removed, traverse till nth-1 and remove the element
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode temp = head;

        while (temp != null) {
            c++;
            temp = temp.next;
        }

        int nth = c - n;
        temp = head;

        if (nth == 0) {
            return head.next;
        }
        while (temp != null && nth - 1 > 0) {
            temp = temp.next;
            nth--;
        }

        temp.next = temp.next.next;

        return head;
    }

    // This process is using fast and slow pointers, that we skip fast to n+1
    // position and move both slow and fast pointers till fast going to null and
    // then remove the element
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
