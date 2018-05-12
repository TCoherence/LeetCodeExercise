class Solution {
    private int lo, maxlen;
    
    public String longestPalindrome(String s) {
        if ( s == null || s.length() == 0 ) return s;
        int len = s.length();
        for (int i = 0; i < len; i++){
            // odd find
            helper(s, i, i);
            // even find
            helper(s, i, i+1);
        }
        return s.substring(lo, lo+maxlen);
    }
    public void helper( String s, int low, int high){
        int len = s.length();
        while ( low > -1 && high < len && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }
        low++;
        high--;
        if ( maxlen < high - low + 1 ) {
            maxlen = high - low + 1;
            lo = low;
        }
    }
}
