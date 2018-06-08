class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        int lenS = s.length();
        int lenT = t.length();
        for ( int i = 0; i < lenS; i++ ){
            res ^= s.charAt(i);
        }
        for ( int i = 0; i < lenT; i++ ){
            res ^= t.charAt(i);
        }
        return res;
    }
    
}
