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
        /* Three points to be noticed:
         * 1. how to avoid repeating searching paths.
         * 2. how to avoid repeating elements(words)
         * 3. in backtracking, when to stop.
         */
        // check para
        if ( board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0 ) return new ArrayList<String>();
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        // build Trie-Tree
        for ( String word : words ){
            addWord ( word, root );
        }
        // search in board
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                boolean tmp = isExist(board, i, j, root, res, set);
            }
        }
        return res;
        
    }
    
    public boolean isExist(char[][] board, int i, int j, TrieNode curNode, List<String> res, Set<String> set) {
        // when to stop
        if ( !curNode.word.equals("") ) {
            if ( !set.contains(curNode.word) ) {
                res.add(curNode.word);
                set.add(curNode.word);
            } 
        }
        // isValidIndex
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length ) return false;
        // isValidValue
        if ( board[i][j] - 'a' < 0 || board[i][j] - 'a' > 25 ) return false;
        
        char curChar = board[i][j];
        board[i][j] -= 26;
        boolean ret = false;
        if ( curNode.child[curChar - 'a'] != null ) {
            ret =   isExist(board, i + 1, j, curNode.child[curChar - 'a'], res, set) ||
                    isExist(board, i - 1, j, curNode.child[curChar - 'a'], res, set) ||
                    isExist(board, i, j + 1, curNode.child[curChar - 'a'], res, set) ||
                    isExist(board, i, j - 1, curNode.child[curChar - 'a'], res, set);
        }
        board[i][j] += 26;
        return ret;
        
        
    }
    
    private class TrieNode {
        public String       word    = "";
        public TrieNode[]   child   = new TrieNode[26];
    }
    
    private void addWord(String word, TrieNode root){
        if ( word == null || word.equals(null) ) return ;
        
        for ( char c : word.toCharArray() ){
            int index = c - 'a';
            if ( root.child[index] == null ){
                root.child[index] = new TrieNode();
            }
            root = root.child[index];
        }
        root.word = word;
    }
