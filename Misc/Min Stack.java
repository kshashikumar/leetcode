class MinStack {

    private Stack<Integer> st = null;
    private Stack<Integer> minSt = null;

    public MinStack() {
       this.st = new Stack<>();
       this.minSt = new Stack<>();
    }
    
    public void push(int val) {
        this.st.push(Integer.valueOf(val));
        if(this.minSt.isEmpty()){
            this.minSt.push(val);
        } else if(this.minSt.peek() >= val){
            this.minSt.push(val);
        }
    }
    
    public void pop() {
        if(!this.st.isEmpty()){
            if(this.st.peek().equals(this.minSt.peek())){
                this.minSt.pop();
            }
            this.st.pop();
        }
    }
    
    public int top() {
        if(!this.st.isEmpty()){
         return this.st.peek();
        }
        return 0;
    }
    
    public int getMin() {
        if(!this.minSt.isEmpty()){
             return this.minSt.peek();
        }
       return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */