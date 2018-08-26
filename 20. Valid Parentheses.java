class Solution {
    public boolean isValid(String s) {
        if( s == null || s.length() % 2 == 1) return false;
        if( s.length() == 0 ) return true;
        
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        //boolean ret = false;
        char peek = 'a';
        for( int i = 0; i < len; i++){
            if( !stack.empty() )   peek = stack.peek();
            stack.push( s.charAt(i) );
            if( ( peek == '(' && stack.peek() == ')' ) ||
                ( peek == '{' && stack.peek() == '}' ) ||
                ( peek == '[' && stack.peek() == ']' )

              ){
                stack.pop();
                stack.pop();
            } 
        }
        return stack.empty();
    }
}

// REDO
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for ( char c : s.toCharArray() ) {
            if ( ( c == ')' && !stack.isEmpty() && stack.pop() == '(' ) || 
                 ( c == '}' && !stack.isEmpty() && stack.pop() == '{' ) || 
                 ( c == ']' && !stack.isEmpty() && stack.pop() == '[' ) ) {
                continue;
            }
            stack.push(c);
            
        }
        return stack.isEmpty();
    }
}
