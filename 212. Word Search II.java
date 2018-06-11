class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if ( words.length == 0 || board == null || board.length == 0 || board[0].length == 0) return res;
        int row = board.length;
        int col = board[0].length;
        HashSet<String> set = new HashSet<>();
        for ( int i = 0; i < words.length; i++){
            //
            // if ( set.contains(words[i]) ) continue;
            // set.add(words[i]);
            char[] word = words[i].toCharArray();
            for ( int m = 0; m < row; m++ ){
                for ( int n = 0; n < col; n++ ){
                    if ( exist(board, word, 0, m, n) ) {
                        if ( set.contains(words[i]) ) continue;
                        else{
                            set.add(words[i]);
                            res.add(words[i]);
                        }
                        
                    }
                }
            }
        }
        return res;
    }
    public boolean exist(char[][] board, char[] word, int i, int x, int y){
        if ( i == word.length ) return true;
        if ( !valid(x, y, board.length, board[0].length) ) return false;
        if ( board[x][y] != word[i] ) return false;
        board[x][y] ^= 0xff;
        boolean isExist =   exist(board, word, i + 1, x + 1, y) ||
                            exist(board, word, i + 1, x - 1, y) ||
                            exist(board, word, i + 1, x, y + 1) ||
                            exist(board, word, i + 1, x, y - 1);
        board[x][y] ^= 0xff;
        return isExist;
    }
    public boolean valid(int x, int y, int row, int col){
        if ( x < 0 || y < 0 || x >= row || y >= col) return false;
        return true;
    }
}

// need to improve
