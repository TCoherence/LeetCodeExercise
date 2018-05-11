class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_idx = 0;

        if ( s == null || t == null ) return false;
        
        for ( int i = 0; i < t.length(); i++ ){
            if ( s_idx == s.length() ) break;
            if ( t.charAt(i) == s.charAt(s_idx) ) s_idx++;
        }
        return s_idx == s.length();
    }
}
