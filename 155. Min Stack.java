class MinStack {
    private int[] stack;
    private int index = -1;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[1];
    }
    
    public void push(int x) {
        stack[++index] = x;
        if ( index > -1 && index == stack.length - 1) {
            int[] swap = new int[2*stack.length];
            for ( int i = 0; i <= index; i++ ){
                swap[i] = stack[i];
            }
            stack = swap;
        }
        
    }
    
    public void pop() {
        if ( index == -1 ) return;
        index--;
        if ( index > -1 && index + 1 <= stack.length / 4 ){
            int[] swap = new int[stack.length / 2];
            for ( int i = 0; i <= index; i++ ){
                swap[i] = stack[i];
            }
            stack = swap;
        }
    }
    
    public int top() {
        return stack[index];
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for ( int i = 0; i <= index; i++){
            min = Math.min( min, stack[i] );
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
