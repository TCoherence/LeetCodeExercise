class Solution {
    public int minSteps(int n) {
        // check para
        if ( n <= 0 ) return 0;
        if ( n == 1 ) return 0;
        if ( n == 2 ) return 2;
        
        // find factor's sum
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;
        for ( int i = 3; i < n + 1; i++ ) {
            for ( int j = 2; j < i; j++ ) {
                dp[i] = i;
                if ( i % j == 0 ) {
                    dp[i] = j + dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
        
    }
}
