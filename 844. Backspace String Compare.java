class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int lens = s.length;
        int lent = t.length;
        String s1 = "", t1 = "";
        Stack<Character> stack = new Stack<>();
        for ( int i = 0; i < lens; i++ ){
            if ( s[i] == '#' ) {
                if ( stack.empty() ) continue;
                else stack.pop();
            }
            else{
                stack.push(s[i]);
            }
        }
        while( !stack.empty() ) {
            s1 = stack.pop() + s1;
        }
        for ( int i = 0; i < lent; i++ ){
            if ( t[i] == '#' ) {
                if ( stack.empty() ) continue;
                else stack.pop();
            }
            else{
                stack.push(t[i]);
            }
        }
        while( !stack.empty() ) {
            t1 = stack.pop() + t1;
        }
        return s1.equals(t1);
        
    }
}
