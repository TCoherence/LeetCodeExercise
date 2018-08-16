class Solution {
    public String shortestPalindrome(String s) {
        if ( s == null || s.equals("") ) return s;
        int lastIdx = 1;
        for (int i = s.length(); i > 0; i-- ) {
            if ( isPalindrome(s.substring(0, i)) ) {
                lastIdx = i;
                break;
            }
        }
        return reverse(s.substring(lastIdx)) + s;
        
    }
    public String reverse(String s) {
        if ( s == null || s.equals("") ) return s;
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public boolean isPalindrome(String s) {
        if ( s == null || s.equals("") ) return false;
        int lo = 0, hi = s.length() - 1;
        while ( lo <= hi && s.charAt(lo) == s.charAt(hi) ) {
            lo++;
            hi--;
        }
        return lo > hi ? true : false;
    }
}
