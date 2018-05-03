class Solution {
    public String reverseString(String s) {
        if ( s == null || s.length() == 0 ) return s;
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
