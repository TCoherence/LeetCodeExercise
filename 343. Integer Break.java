class Solution {
    // Only come up with Math Solution and cannot figure out how to solve it with DP
    public int integerBreak(int n) {
        if ( n == 2 ) return 1;
        if ( n == 3 ) return 2;
        if ( n == 4 ) return 4;
        int product = 1;
        while ( n > 4 ){
            product *= 3;
            n -= 3;
        }
        product *= n; // now n == 2 or 3
        return product;
    }
}
