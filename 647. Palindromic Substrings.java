class Solution {
    private int cnt = 0;
    public int countSubstrings(String s) {
        char[] str = s.toCharArray();
        cnt = 0;
        for ( int i = 0; i < str.length; i++ ) {
            helper(str, i, i);
            helper(str, i, i + 1);
        }
        return cnt;
    }
    public void helper(char[] str, int lo, int hi) {
        while ( lo >= 0 && hi < str.length && str[lo] == str[hi] ) {
            lo--;
            hi++;
            cnt++;
        }
    }
}
