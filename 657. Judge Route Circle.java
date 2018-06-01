class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] str = moves.toCharArray();
        for ( int i = 0; i < str.length; i++){
            if ( str[i] == 'U' ){
                y++;
            }
            else if ( str[i] == 'D' ){
                y--;
            }
            else if ( str[i] == 'L' ){
                x--;
            }
            else if ( str[i] == 'R' ){
                x++;
            }
            else{
                throw new java.lang.IllegalArgumentException("Wrong Argument...");
            }
        }
        return ( x == 0 && y == 0);
    }
}
