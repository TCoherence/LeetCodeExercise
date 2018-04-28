class Solution {
    public boolean isPalindrome(String str) {
        String strlow = str.toLowerCase();
        char[] s = strlow.toCharArray();
        int len = s.length;
        for ( int i = 0, j = len - 1; i < j; ){
            if( (s[i] > 96 && s[i] < 123) || (s[i] > 47 && s[i] < 58) ) {}
            else{
                i++;
                continue;
            }
            if( (s[j] > 96 && s[j] < 123) || (s[j] > 47 && s[j] < 58) ) {}
            else{
                j--;
                continue;
            }
            if( s[i] == s[j] ) {
                i++;
                j--;
                continue;
            }
            else return false;
        }
        return true;
    }
}
