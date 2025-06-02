class Node{
    int val;
    Node next;
    Node prev;

    Node(){};

    Node(int val){
        this.val = val;
    }
}

class MyCircularDeque {

    public int capacity,size;
    public Node left = new Node(0);
    public Node right = new Node(0);
    public MyCircularDeque(int k) {
        this.capacity =k;
        this.size=0;
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public boolean insertFront(int value) {
        if(this.size == capacity) return false;

        Node temp = new Node(value);
        temp.next = this.left.next;
        temp.next.prev = temp;

        this.left.next = temp;
        temp.prev = this.left;
        this.size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(this.size == capacity) return false;

        Node temp = new Node(value);
        temp.prev = this.right.prev;
        temp.prev.next = temp;

        this.right.prev = temp;
        temp.next = this.right;
        this.size++;
        return true;

    }
    
    public boolean deleteFront() {
        if(this.size ==0) return false;

        Node temp = this.left.next;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        this.size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(this.size == 0) return false;

        Node temp = this.right.prev;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        this.size--;
        return true;
    }
    
    public int getFront() {
        if(this.size == 0) return -1;
        return this.left.next.val;
    }
    
    public int getRear() {
        if(this.size ==0) return -1;
        return this.right.prev.val;
    }
    
    public boolean isEmpty() {
        return this.size ==0;
    }
    
    public boolean isFull() {
        return this.size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */