class Solution {
    public String longestCommonPrefix(String[] strs) {
        if ( strs == null || strs.length == 0 ) return "";
        if ( strs.length == 1) return strs[0];  //ensure there are 2+ Strings to compare
        int strlen = strs.length;   //  strlen >= 2
        // char[][strlen] chars;
        int minlen = strs[0].length();      // already check the length of strs, it will not outofbound
        for ( int i = 0; i < strlen; i++ ){ // i doesnt increase from 1 for toCharArray()
            if(strs[i].length() == 0) return "";
            minlen = Math.min(strs[i].length(), minlen);
            // chars[][i] = strs[0].toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < minlen ; i++){
            // check for same prelix one by one
            for( int j = 1; j < strlen; j++){
                if ( strs[j - 1].charAt(i) != strs[j].charAt(i) ) return sb.toString(); 
            }
            sb.append(strs[0].charAt(i));
            
        }
        return sb.toString();
    }
}
