class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if ( s == null || s.length() == 0 ) return false;
        int len = s.length();

        for ( int i = len/2; i > 0 ; i-- ) {
            if ( len % i != 0 ) continue;
            int times = len / i;
            String tmp = s.substring(0, i);
            StringBuilder res = new StringBuilder();
            for ( int j = 0; j < times; j++ ) {
                res.append(tmp);
            }
            // System.out.printf("res = %s, tmp = %s, times = %d\n", res, tmp, times);
            if ( res.toString().equals(s) ) return true;
        }
        return false;
    }
}
