class Solution {
    public boolean isAnagram(String s, String t) {
        // check para
        if ( s == null || t == null ) return false;
        if ( s.length() != t.length() ) return false;
        // 
        int[] str = new int[26];
        char[] strOne = s.toCharArray();
        char[] strTwo = t.toCharArray();
        // cal char number of String s
        for ( int i = 0; i < strOne.length; i++ ) {
            str[(int) strOne[i] - 'a']++;
        }
        
        // del char number of String t which stored in str
        for ( int i = 0; i < strTwo.length; i++ ) {
            if ( --str[(int) strTwo[i] - 'a'] < 0 ) return false;
            
        }
        
        // return 
        return true;
    }
}
