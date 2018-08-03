class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // check param
        if ( input == null || input.length() == 0 ) return new ArrayList<Integer>();
        
        List<Integer> res = new ArrayList<Integer>();
        for ( int i = 0; i < input.length(); i++ ) {
            char c = input.charAt(i);
            if ( c == '+' || c == '-' || c == '*' ) {
                List<Integer> left  = diffWaysToCompute(input.substring(0 , i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for ( int a : left ) {
                    for ( int b : right ) {
                        if ( c == '+' ) 
                            res.add(a + b);
                        if ( c == '-' )
                            res.add(a - b);
                        if ( c == '*' ) 
                            res.add(a * b);
                    }
                }
            }
        }
        if ( res.isEmpty() ) res.add(Integer.valueOf(input));
        return res;
    }
}
