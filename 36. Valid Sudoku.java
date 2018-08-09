class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][] subUsed = new boolean[9][9];
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] != '.' ) {
                    int numIdx = board[i][j] - '0' - 1;
                    int subIdx = i / 3 * 3 + j / 3;
                    if ( rowUsed[i][numIdx] || colUsed[j][numIdx] || subUsed[subIdx][numIdx] )
                        return false;
                    else
                        rowUsed[i][numIdx] = colUsed[j][numIdx] = subUsed[subIdx][numIdx] = true;
                }
            }
        }
        return true;
    }
}
