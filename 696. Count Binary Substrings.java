class Solution {
    public int countBinarySubstrings(String s) {
        char[] str = s.toCharArray();
        int prev = 1, cur = 1;
        int res = 0;
        for ( int i = 1; i < str.length; i++ ) {
            if ( str[i] == str[i - 1] ) cur++;
            else {
                prev = cur;
                cur = 1;
            }
            if ( prev >= cur ) res++;
        }
        return res;
    }
}
