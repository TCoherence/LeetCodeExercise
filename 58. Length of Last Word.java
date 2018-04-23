class Solution {
    public int lengthOfLastWord(String s) {
        if ( s == null || s.length() == 0) return 0;
        char[] str = s.toCharArray();
        int len = str.length;
        int sum = 0;
        for( int i = len - 1; i >= 0; i--){
            if ( str[i] == ' ' && sum == 0 ) continue;
            if ( str[i] == ' ' && sum != 0 ) break;
            sum++;
        }
        return sum;
    }
}
