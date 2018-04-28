class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        if ( n == 0 ) {
            ret.add("");
            return ret;
        }
        if ( n < 0 ) {
            return ret;
        } 
        StringBuilder sb = new StringBuilder();
        generateHelper(sb, n, n, ret);
        return ret;
    }
    public void generateHelper(StringBuilder sb, int left, int right, List<String> res){
        

        // come in first from "("
        if ( left > 0 ){
            StringBuilder sbnow = new StringBuilder(sb);
            sbnow.append("(");
            generateHelper(sbnow, left - 1, right, res);
        }
        // if there are more ')' out there, put in first to ensure left >= right
        if ( left < right){
            StringBuilder sbnow = new StringBuilder(sb);
            sbnow.append(")");
            generateHelper(sbnow, left, right - 1, res);
        }
        if ( left == 0 && right == 0 ) {
            res.add(sb.toString());
            return;
        }
    }
}
