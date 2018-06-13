class MyStack {
    Queue<Integer> que1;
    Queue<Integer> que2;
    int id;
    /** Initialize your data structure here. */
    public MyStack() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
        id = 1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (id == 1) {
            while (!que1.isEmpty()) {
                que2.offer(que1.poll());
            }
            que1.offer(x);
        } else {
            while (!que2.isEmpty()) {
                que1.offer(que2.poll());
            }
            que2.offer(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (id == 1) {
            while (que1.size() > 1) {
                que2.offer(que1.poll());
            }
            id = 2;
            return que1.poll();
        } else {
            while (que2.size() > 1) {
                que1.offer(que2.poll());
            }
            id = 1;
            return que2.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if (id == 1) {
            while (que1.size() > 1) {
                que2.offer(que1.poll());
            }
            return que1.peek();
        } else {
            while (que2.size() > 1) {
                que1.offer(que2.poll());
            }
            return que2.peek();
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty() && que2.isEmpty();
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