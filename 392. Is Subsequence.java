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

// a more fast solution with the helper of API
class Solution {
    public boolean isSubsequence(String s, String t) {
        for ( int i = 0, pos = 0; i < s.length(); i++, pos++ ){
            pos = t.indexOf(s.charAt(i), pos);
            if ( pos == -1 ) return false;
        }
        return true;
    }
}
