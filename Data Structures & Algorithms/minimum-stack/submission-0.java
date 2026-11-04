class MinStack {
    PriorityQueue<Integer> minHeap;
    Stack<Integer> st;

    public MinStack() {
        this.minHeap = new PriorityQueue<>();
        this.st = new Stack<>();
    }
    
    public void push(int val) {
        this.minHeap.offer(val);
        this.st.push(val);
    }
    
    public void pop() {
        int val = this.st.pop();
        this.minHeap.remove(val);
    }
    
    public int top() {
        return this.st.peek();
    }
    
    public int getMin() {
        return this.minHeap.peek();
    }
}
