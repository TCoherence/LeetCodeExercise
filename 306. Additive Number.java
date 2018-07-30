class Solution {
    public boolean isAdditiveNumber(String num) {
        
        return helper(num, false);
    }
    public boolean helper(String num, boolean before) {
        long first = 0;
        long second = 0;
        for ( int i = 1; i <= num.length() / 2; i++ ) {
            if ( num.charAt(0) == '0' && i > 1 ) return false;
            first = Long.parseLong(num.substring(0, i));
            for ( int j = 1; Math.max(i, j) <= num.length() - i -j; j++ ) {
                if ( num.charAt(i) == '0' && j > 1 ) break;
                second = Long.parseLong(num.substring(i, i+j));
                if ( isValid(first, second, i + j, num) ) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValid(long first, long second, int start, String num) {
        if ( start == num.length() ) return true;
        Long third = first + second;
        String thirdStr = String.valueOf(third);
        return num.startsWith(thirdStr, start) && isValid(second, third, start + thirdStr.length(), num);
        
    }
}
