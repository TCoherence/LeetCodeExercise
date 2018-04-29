class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if ( digits == null || digits.length() == 0 ) return res;
        char[][] map = new char[8][];
        map[0] = new char[]{'a','b','c'};
        map[1] = new char[]{'d','e','f'};
        map[2] = new char[]{'g','h','i'};
        map[3] = new char[]{'j','k','l'};
        map[4] = new char[]{'m','n','o'};
        map[5] = new char[]{'p','q','r','s'};
        map[6] = new char[]{'t','u','v'};
        map[7] = new char[]{'w','x','y','z'};
        //StringBuilder sb = new StringBuilder();
        char[] digit = digits.toCharArray();
        backtrack(digit, 0, map, "", res);
        return res;
    }
    public void backtrack(char[] digit, int index, char[][] map, String s, List<String> res){
        if( index < digit.length ){
            int i = digit[index] -'0' - 2;
            for( int j = 0; j < map[i].length; j++){
                backtrack(digit, index + 1, map, s+map[i][j], res);
            }
        }
        else {
            res.add(s);
            return;
        }
    }
}
