class Node {
    int val;
    int key;
    Node prev;
    Node next;

    Node() {
    }

    Node(int key, int val) {
        this.val = val;
        this.key = key;
    }

    Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

// Use Map with LinkedList for performing LRU Cache, where left most node in DLL
// is LRU and right most node is more frequent
class LRUCache {
    public int capacity;
    public Map<Integer, Node> mp;
    public Node left = new Node(0, 0);
    public Node right = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>();
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // remove the node provide but updating prev and next pointers
    public void removeright(Node root) {
        if (root.prev != null)
            root.prev.next = root.next;
        if (root.next != null)
            root.next.prev = root.prev;
    }

    // get prev from right and update links between prev and root and then update
    // links between root and right
    public void insert(Node root) {
        Node prev = this.right.prev;
        prev.next = root;
        root.prev = prev;

        root.next = this.right;
        this.right.prev = root;
    }

    // check if key exists in map and then remove the node and re-insert to right
    // return value from node
    public int get(int key) {
        if (this.mp.containsKey(key)) {
            removeright(this.mp.get(key));
            insert(this.mp.get(key));
            return this.mp.get(key).val;
        }
        return -1;
    }

    // check if key exists and remove node, then insert new node to mp and to DLL.
    // If the Map size is more then capacity then remove the left most node from DLL
    // and map
    public void put(int key, int value) {
        if (this.mp.containsKey(key)) {
            removeright(this.mp.get(key));
        }
        this.mp.put(key, new Node(key, value));
        insert(this.mp.get(key));

        if (this.mp.size() > this.capacity) {
            Node lru = this.left.next;
            removeright(lru);
            this.mp.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */