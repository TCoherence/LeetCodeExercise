class MagicDictionary {
    private TrieNode root;
    
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] words) {
        if ( words == null || words.length == 0 ) return ;
        
        for ( String word : words ) {
            TrieNode node = root;
            for ( char c : word.toCharArray() ) {
                if ( node.next[c - 'a'] == null ) 
                    node.next[c - 'a'] = new TrieNode();
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return searchHelper(root, word.toCharArray(), 0, false);
    }
    
    private boolean searchHelper(TrieNode node, char[] str, int depth, boolean used) {
        if ( node == null ) return false;
        if ( depth == str.length ) return node.isWord && used;
        char c = str[depth];
        for ( char j = 'a'; j <= 'z'; j++ ) {
            if ( used && j != c ) continue;
            if ( searchHelper(node.next[j - 'a'], str, depth + 1, used || j != c) ) return true;
        }
        return false;
    }
    
    private class TrieNode {
        private TrieNode[]  next;
        private boolean     isWord;
        TrieNode() {
            this.next = new TrieNode[26];
            this.isWord = false;
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
