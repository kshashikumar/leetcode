class Node{
    int key;
    int val;
    Node prev;
    Node next;
    

    Node(){}

    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    public int capacity;
    public Node left = new Node(0,0);
    public Node right = new Node(0,0);
    public Map<Integer, Node> mp;
    public LRUCache(int capacity) {
        this.left.next = this.right;
        this.right.prev = this.left;
        this.mp = new HashMap<>();
        this.capacity = capacity;
    }

    public void insert(Node root){
        Node temp = this.right.prev;
        temp.next = root;
        root.prev = temp;

        root.next = this.right;
        this.right.prev = root;

    }
    public void remove(Node root){
        if(root.prev!=null){
            root.prev.next = root.next; 
           
        }
       if(root.next!=null){
          root.next.prev = root.prev;
       }
       
    }
    
    public int get(int key) {
        if(this.mp.containsKey(key)){
            remove(this.mp.get(key));
            insert(this.mp.get(key));
            return this.mp.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.mp.containsKey(key)){
            remove(this.mp.get(key));
        }
        
        this.mp.put(key,new Node(key,value));
        insert(this.mp.get(key));

        if(this.mp.size() > this.capacity){
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