class Solution {
    public int nextGreaterElement(int n) {
        char[] s = String.valueOf(n).toCharArray();
        if ( s.length == 1 ) return -1;
        int i = 0;
        for ( i = s.length - 2; i >= 0; i-- ) {
            if ( s[i] < s[i + 1] ) {
                int j = i + 1;
                for ( int k = s.length - 1; k > j; j++, k-- ) {
                    s[j] ^= s[k];
                    s[k] ^= s[j];
                    s[j] ^= s[k];
                }
                for ( j = i + 1; j < s.length; j++ ) {
                    if ( s[j] > s[i] ) {
                        s[j] ^= s[i];
                        s[i] ^= s[j];
                        s[j] ^= s[i];
                        break;
                    }
                }
                break;
            }
        }
        if ( i == -1 || Long.parseLong(new String(s)) > Integer.MAX_VALUE ) 
            return - 1;
        else 
            return Integer.valueOf(new String(s)).intValue();
    }
}
