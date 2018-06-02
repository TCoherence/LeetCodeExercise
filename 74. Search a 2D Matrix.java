/** When use binary search, need to be careful about outofindex and <=.
 *  
 *  
 *  
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return false;
        int targetrow = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0;
        int hi = row - 1;
        int mid = lo + (hi - lo) / 2;
        while ( lo <= hi ) {
            mid = lo + (hi - lo) / 2;
            if ( matrix[mid][0] > target ) hi = mid - 1;
            else if ( matrix[mid][0] < target ) lo = mid + 1;
            else return true;
        }
        if (hi < 0) return false;
        targetrow = hi;
        lo = 0;
        hi = col - 1;
        while( lo <= hi ) {
            mid = lo + ( hi - lo ) / 2;
            if ( matrix[targetrow][mid] > target ) hi = mid - 1;
            else if ( matrix[targetrow][mid] < target ) lo = mid + 1;
            else return true;
        }
        return false;
    }
}
