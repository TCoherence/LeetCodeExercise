class Solution {
    public int titleToNumber(String s) {
        // int[] parse = new int[26];
        // for ( int i = 0; i < 26; i++ ) {
        //     parse[i] = i + 1;
        // }
        char[] str = s.toCharArray();
        int num = 0;
        for ( int i = 0; i < str.length; i++ ) {
            num = num * 26 + str[i] - 'A' + 1;
        }
        return num;
    }
}
