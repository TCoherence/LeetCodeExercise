class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if ( q1.size() == 0 ) 
            q2.offer(x);
        else
            q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if ( q2.size() != 0 ) {
            Queue<Integer> tmp;
            tmp = q1;
            q1 = q2;
            q2 = q1;
        }
        int size = q1.size();
        for ( int i = 0; i < size - 1; i++ ) {
            q2.offer(q1.poll());
        }
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if ( q2.size() != 0 ) {
            Queue<Integer> tmp;
            tmp = q1;
            q1 = q2;
            q2 = q1;
        }
        int size = q1.size();
        for ( int i = 0; i < size - 1; i++ ) {
            q2.offer(q1.poll());
        }
        int ret = q1.poll();
        q2.offer(ret);
        return ret;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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
