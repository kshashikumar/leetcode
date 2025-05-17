class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(){}

    Node(int k,int v){
        this.key = k;
        this.val = v;
    }
}
class LRUCache {

    public Map<Integer,Node> mp;
    public Node left = new Node(0,0);
    public Node right = new Node(0,0);
    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>();
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node root){
        if(root.prev != null){
            root.prev.next = root.next;
        }
        if(root.next !=null){
            root.next.prev = root.prev;
        }
    }

    public void insert(Node root){
        Node temp = this.right.prev;
        temp.next = root;
        root.prev = temp;

        this.right.prev = root;
        root.next = this.right;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
            insert(mp.get(key));
            return mp.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        Node newNode = new Node(key,value);
        mp.put(key,newNode);
        insert(newNode);
        if(mp.size() > capacity){
            Node lru = this.left.next;
            remove(lru);
            mp.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */