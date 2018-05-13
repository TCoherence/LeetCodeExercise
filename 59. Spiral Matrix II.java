class Solution {
    public int[][] generateMatrix(int n) {
        if ( n <= 0 ) throw new java.lang.IllegalArgumentException();
        int[][] res = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int count = 1;
        if (n == 1) {
            res[0][0] = 1;
            return res;
        }
        while( res[rowBegin][colBegin] == 0 ){
            // go right
            for ( int j = colBegin; j <= colEnd; j++ ){
                res[rowBegin][j] = count++;
            }
            rowBegin++;
            // go down
            for ( int i = rowBegin; i <= rowEnd; i++ ){
                res[i][colEnd] = count++;
            }
            colEnd--;
            // go left
            for ( int j = colEnd; j >= colBegin; j-- ){
                res[rowEnd][j] = count++;
            }
            rowEnd--;
            // go up
            for ( int i = rowEnd; i >= rowBegin; i-- ){
                res[i][colBegin] = count++;
            }
            colBegin++;
        }
        return res;
    }
}
