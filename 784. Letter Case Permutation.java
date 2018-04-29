class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        if ( S == null ) return result;
        if ( S.length() == 0 ) {
            result.add("");
            return result;
        }
        char[] s = S.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = s.length;
        helper(s, sb, result, 0, len);
        return result;
    }
    public void helper(char[] s, StringBuilder sb, List<String> result, int i, int len){
        StringBuilder sbnow = new StringBuilder(sb);
        if ( i < len ) {
            sbnow.append(s[i]);
            helper( s, sbnow, result, i + 1, len);
            if( s[i] >= 'a' && s[i] <= 'z' ){
                s[i] += 'A' - 'a';
                sbnow.setCharAt(i, s[i]);
                s[i] -= 'A' - 'a';
                helper( s, sbnow, result, i + 1, len);
            } 
        }
        else{
            result.add(sb.toString());
            return;
        }
    }
}
