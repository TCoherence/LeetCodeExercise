class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < tokens.length; i++ ){
            if ( tokens[i].equals("+") ){
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 + op1);
            }
            else if ( tokens[i].equals("-") ) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 - op1);
            }
            else if ( tokens[i].equals("*") ) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 * op1);
            }
            else if ( tokens[i].equals("/") ) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 / op1);
            }
            else 
                stack.push( Integer.parseInt(tokens[i]) );
        }
        return stack.pop();
    }
}
