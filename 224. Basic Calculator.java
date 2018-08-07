class Solution {
    public int calculate(String s) {
        if ( s == null || s.equals("") ) return 0;
        s = s.replace(" ","");
        // s = '0' + s + '#';
        Stack<Character> op = new Stack<>();
        Stack<Integer>   stack = new Stack<>();
        int i = 0, j = 0;
        while ( j <= s.length() ) {
            if ( j == s.length()  ) {
                if ( j > i )
                    stack.push(Integer.valueOf(s.substring(i,j)));
                break;
            }
            if ( s.charAt(j) == '('  || s.charAt(j) == '+' || s.charAt(j) == '-' ) {
                op.push(s.charAt(j));
                if ( j > i ) 
                    stack.push(Integer.valueOf(s.substring(i,j)));
                i = j + 1;
            }
            if ( s.charAt(j) == ')' ){
                int res = 0;
                if ( j > i ) 
                    stack.push(Integer.valueOf(s.substring(i,j)));
                while ( op.peek() != '(' ) {
                    if ( op.pop() == '+' ) 
                        res += stack.pop();
                    else
                        res -= stack.pop();
                }
                op.pop();
                if ( stack.size() != 0 ) 
                    res += stack.pop();
                stack.push(res);
                i = j + 1;
            }
            j++;
        }
        int ret = 0;
        while ( op.size() != 0 ) {
            if ( op.pop() == '+' ) 
                ret += stack.pop();
            else
                ret -= stack.pop();
        }
        if ( stack.size() != 0 ) ret += stack.pop();
        return ret;
    }
}


class Solution {
    public int calculate(String s) {
        if ( s == null || s.equals("") ) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;
        for ( char c : s.toCharArray() ) {
            if ( Character.isDigit(c) ) {
                num = num * 10 + (int)c - '0';
            }
            else if ( c == '+' ) {
                res += num * sign;
                sign = 1;
                num = 0;
            }
            else if ( c == '-' ) {
                res += num * sign;
                sign = -1;
                num = 0;
            }
            else if ( c == '(' ) {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                num = 0;
            }
            else if ( c == ')' ) {
                res += num * sign;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if ( num != 0 ) res += num * sign;
        return res;
    }
}
