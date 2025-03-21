class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(){}

    Node(int k,int v){
        this.key = k;
        this.value = v;
    }
}

class LRUCache {
    public int capacity;
    public Node left=new Node(0,0);
    public Node right=new Node(0,0);
    public Map<Integer,Node> mp; 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>();
        this.left.next = this.right;
        this.right.prev = this.left;
    }


    // remove the node from the linkedlist
    // and update the prev and next pointers
    public void remove(Node root){
        if(root.prev!=null){
            root.prev.next = root.next;
        }
        if(root.next !=null){
            root.next.prev = root.prev;
        }
    }

    // insert the node to the linkedlist
    // and update the prev and next pointers
    // we are always inserting the node before the right pointer
    // so that the most recently used node is always at the right

    public void insert(Node root){
        Node temp = this.right.prev;
        temp.next = root;
        root.prev = temp;

        root.next = this.right;
        this.right.prev = root;
    }
    
    // get the value of the key from the hashmap
    // if the key is present in the hashmap
    public int get(int key) {
        if(this.mp.containsKey(key)){
            remove(this.mp.get(key));
            insert(this.mp.get(key));
            return this.mp.get(key).value;
        }
        return -1;
    }
    
    // put the key value pair in the hashmap
    // if the key is already present in the hashmap
    // we need to remove the node from the linkedlist
    // and insert the node to the linkedlist
    // if the key is not present in the hashmap
    // we need to insert the node to the linkedlist
    // if the size of the hashmap is greater than the capacity
    // we need to remove the least recently used node from the linkedlist
    // and remove the node from the hashmap
    // and update the prev and next pointers
    public void put(int key, int value) {
        if(this.mp.containsKey(key)){
            remove(this.mp.get(key));
        }

        mp.put(key,new Node(key,value));
        insert(this.mp.get(key));

        if(mp.size()>this.capacity){
            Node lru = this.left.next;
            remove(lru);
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