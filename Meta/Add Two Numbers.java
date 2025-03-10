public class Add
Two Numbers
{
    //Add two numbers by adding two nodes and take the carry, and add new Node to end
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = c + x + y;
            int d = sum % 10;
            c = sum / 10;
            ListNode newNode = new ListNode(d);
            head.next = newNode;
            head = head.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (c > 0) {
            ListNode carry = new ListNode(c);
            head.next = carry;
        }

        return temp.next;

    }
}
