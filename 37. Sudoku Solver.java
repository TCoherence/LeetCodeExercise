class Solution {
    public void solveSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][] subUsed = new boolean[9][9];
        for ( int i = 0; i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                if ( board[i][j] != '.' ) {
                    int numIdx = board[i][j] - '1';
                    int subIdx = i / 3 * 3 + j / 3;
                    rowUsed[i][numIdx] = colUsed[j][numIdx] = subUsed[subIdx][numIdx] = true;
                }
            }
        }
        int i = 0, j = 0;
        boolean flag = false;
        for ( i = 0; i < row; i++ ) {
            for ( j = 0; j < col; j++ ) {
                if ( board[i][j] == '.' ) {
                    flag = true;
                    break;
                }
            }
            if ( flag ) {
                break;
            }
        }
        backtrack(board, i, j, rowUsed, colUsed, subUsed);
    }
    public boolean backtrack(char[][] board, int r, int c, boolean[][] rowUsed, boolean[][] colUsed, boolean[][] subUsed) {
        // System.out.printf("r = %d, c = %d   ", r, c);
        if ( r == board.length ) return true;
        int nextRow = r, nextCol = c;
        boolean flag = false;
        board[r][c] = '0';
        for ( int i = r; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] == '.' ) {
                    nextRow = i;
                    nextCol = j;
                    flag = true;
                    break;
                }
            }
            if ( flag )
                break;
        }
        if ( nextRow == r && nextCol == c) {
            nextRow = board.length;
        }
        board[r][c] = '.';
        for ( int i = 0; i < 9; i++ ) {
            int subIdx = r / 3 * 3 + c / 3;
            if ( rowUsed[r][i] || colUsed[c][i] || subUsed[subIdx][i] ) continue;
            board[r][c] = (char)('1' + i);
            // System.out.printf("board[%d][%d] = %s \n", r, c, board[r][c]);
            rowUsed[r][i] = colUsed[c][i] = subUsed[subIdx][i] = true;
            if ( backtrack(board, nextRow, nextCol, rowUsed, colUsed, subUsed) ) return true;
            rowUsed[r][i] = colUsed[c][i] = subUsed[subIdx][i] = false;
            board[r][c] = '.';
        }

        return false;
    }
    

    
    
    
    // public boolean isValid(char[][] board, int i, int j, boolean[][] rowUsed, boolean[][] colUsed, boolean[][] subUsed) {
    //     int numIdx = board[i][j] - '0' - 1;
    //     int subIdx = i / 3 * 3 + j / 3;
    //     if ( rowUsed[i][numIdx] || colUsed[j][numIdx] || subUsed[subIdx][numIdx] ) {
    //         return false;
    //     }
    //     else
    //         return true;
    // }
}
