class Trie {
    private TrieNode        root;
    
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for ( char c : word.toCharArray() ) {
            if ( node.next[c - 'a'] == null ) 
                node.next[c - 'a'] = new TrieNode();
            node = node.next[c - 'a'];
            node.startWith = true;
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for ( char c : word.toCharArray() ) {
            if ( node.next[c - 'a'] == null ) return false;
            node = node.next[c - 'a'];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for ( char c : prefix.toCharArray() ) {
            if ( node.next[c - 'a'] == null ) return false;
            node = node.next[c - 'a'];
        }
        return node.startWith;
    }
    
    private class TrieNode {
        private boolean startWith;
        private boolean isWord;
        private TrieNode[] next;
        TrieNode() {
            this.startWith = false;
            this.isWord = false;
            this.next = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
