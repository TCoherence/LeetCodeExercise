/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mid = ( lo + hi ) / 2;
        while ( lo <= hi ) {
            mid = lo + ( hi - lo ) / 2;
            if ( isBadVersion(mid) ) {
                if ( !isBadVersion( mid - 1) ) return mid;
                else hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return -1;
    }
}

// THE MOST IMPORTANT IS TO AVOID OVERFLOW BY CALCULATE mid by lo + (hi - lo) / 2
