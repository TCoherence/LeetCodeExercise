class Solution {
    public boolean isPerfectSquare(int num) {
        if ( num <= 0 ) return false;
        int delta = 1;
        while ( num > 0 ) {
            num -= delta;
            delta += 2;
        }
        return num == 0;
    }
}
