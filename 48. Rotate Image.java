class Solution {
    public void rotate(int[][] matrix) {
        if ( matrix == null || matrix.length == 0 ) return;
        int len = matrix.length;
        for ( int i = 0; i <= len/2 ; i++){
            for ( int j = i; j < len - 1 - i; j++){
                int swap = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = matrix[i][j];
                matrix[i][j] = swap;
            }
        }
            
    }
}
