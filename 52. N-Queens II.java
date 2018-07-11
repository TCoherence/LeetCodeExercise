class Solution {
    private int     count;
    private int     SIZE;
    private int[]   queens;
    public int totalNQueens(int n) {
        if ( n <= 0 ) return 0;
        
        // param init
        count = 0;
        SIZE = n;
        queens = new int[SIZE];
        Arrays.fill(queens, -1);
        int k = 0;
        while ( queens[0] < SIZE ) {
            // find solution
            while ( k >= 0 && k < SIZE ) {
                int j = findPos(k); // try to place a queen at (k, j)
                if ( j < 0 ) {
                    queens[k] = -1;
                    k--;
                }
                else {
                    queens[k] = j;
                    k++;
                }
            }
            if ( k < 0 ){
                break;
            }
            // find one
            else{
                count++;
                k--;
                queens[k] = -1;
                k--;
            }
        }
        return count;
    }
    
    public int findPos(int k) {
        for ( int j = queens[k] + 1; j < SIZE; j++ ) {
            if ( isValid(k, j) ) 
                return j;
        }
        return -1;
    }
    
    public boolean isValid(int k, int j) {
        for ( int i = 0; i < k; i++ ) {
            if ( queens[i] == j         ||  // col overlap
                 queens[i] - j == k - i ||  // right diagonal overlap
                 j - queens[i] == k - i     // left diagonal overlap
            )
                return false;
        }
        return true;
    }
}
