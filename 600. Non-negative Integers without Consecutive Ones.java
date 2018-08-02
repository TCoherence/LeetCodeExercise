class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        String s = sb.toString();
        
        int len = s.length();
        int[] one = new int[len];
        int[] zero = new int[len];
        one[0] = 1;
        zero[0] = 1;
        for ( int i = 1; i < len; i++ ) {
            one[i] = zero[i - 1];
            zero[i] = one[i - 1] + zero[i - 1];
        }
        int res = one[len - 1] + zero[len - 1];
        for ( int i = len - 2; i >= 0; i-- ) {
            if ( s.charAt(i) == '1' && s.charAt(i + 1) == '1' ) break;
            if ( s.charAt(i) == '0' && s.charAt(i + 1) == '0' ) res -= one[i];
        }
        return res;
    }
}
