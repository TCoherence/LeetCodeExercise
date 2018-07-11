class Solution {
    private int     SIZE;   // size of N-queen
    private int[]   queens; // an array record pos of queens when find a solution

    public List<List<String>> solveNQueens(int size) {
        // check para
        if ( size <= 0 ) return new ArrayList<List<String>>();
        
        // param init
        SIZE = size;
        List<List<String>> res = new ArrayList<List<String>>();  // store solution
        // List<String> list = ArrayList<String>();          // help res to store solution
        queens = new int[SIZE];
        Arrays.fill(queens, -1);
        int k = 0;                                          // k-th row to place a queen
        while( queens[0] < SIZE ) {
            // find possible solutions
            while ( k >= 0 && k < SIZE) {
                int j = findPos(k);                             // place a queen in (k, j)
                if ( j < 0 ) {
                    queens[k] = -1;
                    k--;
                }
                else {
                    queens[k] = j;
                    k++;
                }
            }
            if ( k < 0 ) {
                break;
            }
            else{
                // k == SIZE, we record this now and go back to the last but one row and keep searching another possible solutions
                record(queens, res);
                k--;
                queens[k] = -1;
                k--;
            }
        }
        return res;
        
        
    }
    public int findPos(int k){
        for ( int j = queens[k] + 1; j < SIZE; j++){
            if ( isValid(k ,j) ) 
                return j;
        }
        return -1;
    }
    
    public boolean isValid(int k, int j) {
        for ( int i = 0; i < k; i++ ) {
            if ( queens[i] == j ||          // col overlap
                 j - queens[i] == k - i ||  // downright overlap
                 queens[i] - j == k - i     // downleft overlap
               ) 
                return false;
        }
        return true;
    }
    
    public void record(int[] queens, List<List<String>> res){
        List<String> list = new ArrayList<>();
        for ( int i = 0; i < SIZE; i++ ) {
            int k       = queens[i];
            String str  = "";
            for ( int j = 0; j < SIZE; j++ ) {
                if ( j == k ) 
                    str += 'Q';
                else
                    str += '.';
            }
            list.add(str);
        }
        res.add(list);
    }
}
