class MyStack {
    Queue<Integer> que;
    /** Initialize your data structure here. */
    public MyStack() {
        que = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        que.offer(x);
        int n = que.size();
        for (int i = 1; i < n; i++) 
            que.offer(que.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return que.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return que.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */