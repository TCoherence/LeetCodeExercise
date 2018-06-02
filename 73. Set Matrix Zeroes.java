/** O(m+n) solution is using two more extra array to record which row or col need to be reset
 *  O(1) solution is using the first row and col to record which row or col need to be reset, so when we deal with 
 *  the first row and col with a specific way, not with a generic way.
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return;
        boolean firstrow = false, firstcol = false;
        int row = matrix.length;
        int col = matrix[0].length;
        // use first row and first col as flag to identify which row and col need to be reset
        for ( int i = 0; i < row; i++ ){
            for ( int j = 0; j < col; j++ ){
                if ( matrix[i][j] == 0 ) {
                    if ( i == 0 ) firstrow = true;
                    if ( j == 0 ) firstcol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }                                           
            }
        }
        //
        for ( int i = 1; i < row; i++ ){
            for ( int j = 1; j < col; j++ ){
                if ( matrix[i][0] == 0 || matrix[0][j] == 0 ) matrix[i][j] = 0;
            }
        }
        if ( firstrow ){
            for ( int j = 0; j < col; j++ ){
                matrix[0][j] = 0;
            }
        }
        if ( firstcol ){
            for ( int i = 0; i < row; i++ ){
                matrix[i][0] = 0;
            }
        }
    }
}
