public class Insert
into a
Sorted Circular
Linked List
{
     // use two pointers to move in tree prev and cur and handles three cases and insert 1) inserting in middle 2) inserting at ends and 3) iterate over linkedlist only once to find place where to insert
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head, cur = head.next;

        while (cur != head) {
            if (prev.val <= insertVal && insertVal <= cur.val) {
                break;
            }
            if (prev.val > cur.val && (insertVal >= prev.val || insertVal <= cur.val)) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        prev.next = newNode;
        newNode.next = cur;
        return head;
    }
}
