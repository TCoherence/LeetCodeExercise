class Solution {
    public boolean exist(char[][] board, String word) {
        if ( board == null || board.length == 0 || board[0].length == 0) return false;
        char[] target = word.toCharArray();
        for ( int i = 0; i < board.length; i++){
            for ( int j = 0; j < board[0].length; j++){
                if ( exist( board, target, 0, i, j) ) return true;
            }
        }
        return false;
        
        // return exist(board, target, 0, 0, 0);
    }
    public boolean exist(char[][] board, char[] word, int i, int x, int y){
        // if length equals, return true
        if ( i == word.length ) return true;
        // if index not valid, return false
        if ( !valid(x, y, board.length, board[0].length) ) return false;
        // if word not match, return false
        if ( board[x][y] != word[i] ) return false;
        board[x][y] ^= 0xff;
        boolean isExist =   exist( board, word, i + 1, x + 1, y) ||
                            exist( board, word, i + 1, x - 1, y) ||
                            exist( board, word, i + 1, x, y + 1) ||
                            exist( board, word, i + 1, x, y - 1);
        board[x][y] ^= 0xff;
        return isExist;
    }
    public boolean valid(int x, int y, int row, int col){
        if ( x < 0 || y < 0 || x > row - 1 || y > col - 1) return false;
        else return true;
    }
}
