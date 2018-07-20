class Solution {
    /* in-place:
     * 4 states to represent :
     * 0 : dead  -> dead
     * 1 : alive -> alive
     * 2 : alive -> dead
     * 3 : dead  -> alive
     */
    public void gameOfLife(int[][] board) {
        // check param
        if ( board == null || board.length == 0 || board[0].length == 0 ) return ;
        
        int row = board.length;
        int col = board[0].length;
        // update 
        for ( int i = 0; i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                int cnt = 0;
                if ( i > 0 && j > 0 &&              (board[i - 1][j - 1] == 2 || board[i - 1][j - 1] == 1) ) cnt++;
                if ( i > 0 &&                       (board[i - 1][  j  ] == 2 || board[i - 1][  j  ] == 1) ) cnt++;
                if ( i > 0 && j < col - 1 &&        (board[i - 1][j + 1] == 2 || board[i - 1][j + 1] == 1) ) cnt++;
                
                if ( i < row - 1 && j > 0 &&        (board[i + 1][j - 1] == 2 || board[i + 1][j - 1] == 1) ) cnt++;
                if ( i < row - 1 &&                 (board[i + 1][  j  ] == 2 || board[i + 1][  j  ] == 1) ) cnt++;
                if ( i < row - 1 && j < col - 1 &&  (board[i + 1][j + 1] == 2 || board[i + 1][j + 1] == 1) ) cnt++;
                
                if ( j > 0 &&                       (board[  i  ][j - 1] == 2 || board[  i  ][j - 1] == 1) ) cnt++;
                if ( j < col - 1 &&                 (board[  i  ][j + 1] == 2 || board[  i  ][j + 1] == 1) ) cnt++;
                if ( board[i][j] == 0 ) {
                    if ( cnt == 3 ) 
                        board[i][j] = 3;
                }
                else { 
                    if ( cnt != 3 && cnt != 2 ) 
                        board[i][j] = 2;
                }
            }
        }
        for ( int i = 0; i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                if ( board[i][j] == 2 || board[i][j] == 3 ) 
                    board[i][j] -= 2;
            }
        }
        return ;
    }
}
