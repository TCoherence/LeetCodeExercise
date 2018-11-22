class Solution {
    public int myAtoi(String str) {
        if ( str == null ) return 0;
        str = str.trim();
        if ( str.length() == 0 ) return 0;
        
        long sum = 0;
        int sign = 1;
        char signChar = str.charAt(0);
        if ( signChar != '+' && signChar != '-' && !Character.isDigit(signChar) ) return 0;
        if ( signChar == '+' ) {
            sign = 1;
        }
        else if ( signChar == '-' ) {
            sign = -1;
        }
        else {
            sum = signChar - '0';
        }
        for ( int i = 1; i < str.length(); i++ ) {
            if ( !Character.isDigit(str.charAt(i)) ) {
                return new Long(sign*sum).intValue();
            }
            sum = sum * 10 + (str.charAt(i) - '0');
            if ( sign*sum > Integer.MAX_VALUE ) {
                return Integer.MAX_VALUE;
            }
            if ( sign*sum < Integer.MIN_VALUE ) {
                return Integer.MIN_VALUE;
            }
        }
        return new Long(sign*sum).intValue();
    }
}
