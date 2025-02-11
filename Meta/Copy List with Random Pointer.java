class Solution {
    // Use map to initially stor the Node, new Node. After that loop over original
    // ll and then link the new nodes in map to there related ndes based on original
    // nodes and return head node
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> mp = new HashMap<>();

        Node original = head;
        while (original != null) {
            mp.put(original, new Node(original.val));
            original = original.next;
        }

        original = head;
        while (original != null) {
            mp.get(original).next = mp.get(original.next);
            mp.get(original).random = mp.get(original.random);
            original = original.next;
        }

        return mp.get(head);

    }
}