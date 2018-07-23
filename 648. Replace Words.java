class Solution {
    TrieNode root;
    
    public String replaceWords(List<String> dict, String sentence) {
        // check param
        if ( dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0 ) return sentence;
        
        root = new TrieNode();
        for ( String word : dict ) {
            TrieNode node = root;
            for ( char c : word.toCharArray() ) {
                if ( node.next[c - 'a'] == null ) {
                    node.next[c - 'a'] = new TrieNode();
                } 
                node = node.next[c - 'a'];
            }
            node.isRoot = true;
            node.word = word;
        }
        int l = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        while ( r < sentence.length() ) {
            l = r;
            r = sentence.indexOf(' ', r);
            if ( r == -1 ) r = sentence.length();
            String str = sentence.substring(l, r);
            r++;
            if ( isFromRoot(str) ) {
                sb.append(rootOf(str));
            }
            else {
                sb.append(str);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
        
        
    }
    public boolean isFromRoot(String str) {
        TrieNode node = root;
        for ( char c : str.toCharArray() ) {
            if ( node.next[c - 'a'] != null ) {
                node = node.next[c - 'a'];
                if ( node.isRoot ) 
                    return true;
            }
            else
                return false;
        }
        return false;
    }
    public String rootOf(String str) {
        TrieNode node = root;
        for ( char c : str.toCharArray() ) {
            if ( node.next[c - 'a'] != null ) {
                node = node.next[c - 'a'];
                if ( node.isRoot )
                    break;
            }
        }
        return node.word;
    }
    
    private class TrieNode {
        private TrieNode[]  next;
        private String      word = "";
        private boolean     isRoot = false;
        TrieNode() {
            next = new TrieNode[26];
        }
    }
}
