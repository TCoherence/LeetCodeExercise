public class Solution {
    /* We take the last-appear-index as separator, because these index refers to 
     * the last-index of characters, if they are the only one, they can not be deletd,
     * otherwise they can be deleted if they will appear before the last-appear-index.
     * 
     * 1.   char only appear once, we have to keep it ---> separator ---> 
     *      provide the condition that every char will keep relative order.
     * 2.   before those only appear once, we have to pick up smallest 
     *      char to satisfy second requirement --- lexicographical order
     */
    public String removeDuplicateLetters(String s) {
        // check param
        if ( s == null || s.equals("") ) return s;
        
        int[] freq = new int[26];
        boolean[] isValid = new boolean[26];
        
        int minIndex = 0;
        // count freq
        for ( char c : s.toCharArray() ) {
            freq[c - 'a']++;
            isValid[c - 'a'] = true;
        }
        int i = 0;
        String res = "";
        while ( i < s.length() ) {
            
            if ( isValid[s.charAt(i) - 'a'] && s.charAt(i) < s.charAt(minIndex) ){
                minIndex = i;
            }
            
            if ( isValid[s.charAt(i) - 'a'] && freq[s.charAt(i) - 'a']-- == 1 ) {
                if ( isValid[s.charAt(minIndex) - 'a'] ) {
                    res = res + s.charAt(minIndex);
                    isValid[s.charAt(minIndex) - 'a'] = false;
                    freq = new int[26];
                    for ( int j = minIndex + 1; j < s.length(); j++ ) {
                        char c = s.charAt(j);
                        freq[c - 'a']++;
                    }
                    
                    
                    while ( minIndex < s.length() && !isValid[s.charAt(minIndex) -'a'] ) 
                        minIndex++;
                    i = minIndex - 1;
                }
                
            }
            
            i++;
        }
        
        // return result
        return res;
    }
}
