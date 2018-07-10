class WordDictionary {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if ( word == null || word.equals(null) ) return ;
        TrieNode node = root;
        for( char c : word.toCharArray() ) {
            int index = c - 'a';
            if ( node.child[index] == null ) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.isExist = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    private boolean match(String word, int k, TrieNode curNode){
        if ( curNode == null ) return false;
        if ( k == word.length() ) return curNode.isExist;
        
        if ( word.charAt(k) != '.' ) {
            return match(word, k + 1, curNode.child[word.charAt(k) - 'a']);
        }
        else {
            for (int i = 0; i < root.child.length; i++ ) {
                if ( match(word, k + 1, curNode.child[i]) ) return true;
            }
        }
        return false;
    }
    
    private class TrieNode {
        public boolean isExist = false;
        public TrieNode[] child = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
