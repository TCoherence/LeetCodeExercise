/* 
 * Be careful to q.size() especially when it is applied in loop, because of its dynamic value, the loop 
 * will execute in wrong way.
 * 
 * 
 * 
 */
class MyQueue {
    Stack<Integer> q1;
    Stack<Integer> q2;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        q1 = new Stack<>();
        q2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        q1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if ( q2.isEmpty() ) {
            while ( !q1.isEmpty() ){
                q2.push(q1.pop());
            }
        }
        return q2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if ( q2.isEmpty() ) {
            while ( !q1.isEmpty() ){
                q2.push(q1.pop());
            }
        }
        return q2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
