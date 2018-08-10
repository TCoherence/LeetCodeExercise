/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        int mid = lo + (hi - lo)/2;
        while ( lo <= hi ) {
            mid = lo + (hi - lo)/2;
            int cmp = guess(mid);
            if ( cmp > 0 ) 
                lo = mid + 1;
            else if ( cmp < 0 ) 
                hi = mid - 1;
            else 
                return mid;
        }
        return -1;
        
    }
}
