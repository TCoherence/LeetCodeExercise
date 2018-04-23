class Solution {
    public int mySqrt(int x) {
        if ( x < 0 ) return Integer.MIN_VALUE;
        int low = 0;
        int high = 46340;   // because sqrt(integer.MAX_VALUE) = 46340.950
        int mid = (low+high) / 2;
        while( low <= high ){
            mid = (low+high) / 2;
            if ( mid * mid == x) return mid;
            if ( mid * mid < x ) low = mid + 1;
            if ( mid * mid > x ) high = mid - 1;
        }
        if( mid * mid > x) return mid-1;
        else return mid;
    }
}
