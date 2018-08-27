class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, 0, res, '(', ')');
        return res;
    }
    public void helper(String s, int pioneer, int checker, List<String> res, char open, char close) {
        int counter = 0;
        for ( int i = pioneer; i < s.length(); i++ ) {
            if ( s.charAt(i) == open  ) counter++;
            if ( s.charAt(i) == close ) counter--;
            if ( counter < 0 ) { // more close parenthesis found
                // begin to loop throught previous chars to del one close parenthesis from the same groups
                for ( int j = checker; j <= i; j++ ) {
                    if ( s.charAt(j) == close && ( j == checker || s.charAt(j - 1) != close ) ) { // we use s.charAt(j - 1) != close instead of s.charAt(j - 1) == open to avoid cases like (a)())()
                        helper(s.substring(0, j) + s.substring(j + 1), i, j, res, open, close);
                    }
                }
                return ;
            }
        }
        // if no more close parentheses found, check whether more open parentheses can be found
        String reverse = new StringBuilder(s).reverse().toString();
        if ( open == '(' ) {
            helper(reverse, 0, 0, res, close, open);
        }
        else {
            // if more open parentheses checked and valid, we come to this line and use reverseString to as return variance, very brilliant
            res.add(reverse);
        }
    }
}
