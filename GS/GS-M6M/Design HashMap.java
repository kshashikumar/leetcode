class ListNode{
    int key;
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int k,int v){
        this.key = k;
        this.val = v;
    }
}

class MyHashMap {
    private final int SIZE = 1000;

    ListNode[] buckets;
    public MyHashMap() {
        buckets = new ListNode[SIZE];
    }

    public int hash(int key){
        return key % SIZE;
    }

    public ListNode find(ListNode head, int key){
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }


    
    public void put(int key, int value) {
        int idx = hash(key);

        if(buckets[idx] == null){
            buckets[idx] = new ListNode(-1,-1);
        }

        ListNode prev = find(buckets[idx],key);

        if(prev.next == null){
            prev.next = new ListNode(key,value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = hash(key);

        if(buckets[idx] == null){
            return -1;
        }

        ListNode prev = find(buckets[idx],key);
        if(prev.next == null){
            return -1;
        }

        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = hash(key);

        if(buckets[idx] == null){
            return;
        }

        ListNode prev = find(buckets[idx],key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */