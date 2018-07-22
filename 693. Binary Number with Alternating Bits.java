class Solution {
    public boolean hasAlternatingBits(int n) {
        while ( n != 0 ) {
            if ( (n & 1) == 1 ) {
                n = n >>> 1;
                if ( (n & 1) == 1 ) return false;
            }
            else {
                n = n >>> 1;
                if ( (n & 1) == 0 ) return false;
            }
        }
        return true;
    }
}
