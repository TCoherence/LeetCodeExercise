class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // check param
        if ( n < 1 || primes == null || primes.length == 0 ) return -1;
        
        int[] idx = new int[primes.length]; // from 1 to the last, eg 1 2 7 13 19
        // int index = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for ( int i = 1; i < n; i++ ) {
            dp[i] = Integer.MAX_VALUE;
            for ( int j = 0; j < primes.length; j++ ) {
                dp[i] = Math.min(dp[i], dp[idx[j]] * primes[j]);
            }
            for ( int j = 0; j < primes.length; j++ ) {
                if ( dp[i] == dp[idx[j]] * primes[j] ) idx[j]++; // keypoint
            }
        }
        System.out.printf("dp = %s\n", Arrays.toString(dp));
        return dp[n - 1];
    }
}
