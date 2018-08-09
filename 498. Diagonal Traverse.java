class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        // check param
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return new int[0];
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int[][] dir = {{-1, 1}, {1, -1}};
        int row = 0, col = 0, d = 0;
        for ( int i = 0; i < m * n; i++ ) {
            res[i] = matrix[row][col];
            row += dir[d][0];
            col += dir[d][1];
            
            if ( row >= m ) {   // upper bounder
                row = m - 1;
                col += 2;
                d = 1 - d;
            }
            if ( col >= n ) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }
            if ( row < 0 ) {
                row = 0;
                d = 1 - d;
            }
            if ( col < 0 ) {
                col = 0;
                d = 1 - d;
            }
        }
        return res;
    }
}
